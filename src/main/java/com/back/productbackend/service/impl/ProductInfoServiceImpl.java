package com.back.productbackend.service.impl;


import com.back.productbackend.db.entity.ProductInfo;
import com.back.productbackend.db.mapper.ProductInfoMapper;
import com.back.productbackend.page.Pagination;
import com.back.productbackend.service.ProductInfoService;
import com.back.productbackend.db.vo.ProductVO;
import com.back.productbackend.utils.TextUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunke
 * @DATE 2021/12/27
 **/
@Service
@Slf4j
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfo findOne(String id) {
        return null;
    }

    @Override
    public Pagination<ProductVO> findAll(Integer type, Integer pageIndex, Integer pageSize) {
        List<ProductInfo> infos = productInfoMapper.queryProsByCategoryType(type);
        Pagination<ProductInfo> infoPagination = Pagination.<ProductInfo>page(pageIndex, pageSize,
                () -> productInfoMapper.queryProsByCategoryType(type));
        return infoPagination.transform(v -> ProductVO
                .builder()
                .id(v.getId())
                .name(v.getName())
                .price(v.getPrice())
                .categoryType(v.getCategoryType())
                .icon(v.getIcon())
                .description(v.getDescription())
                .createTime(v.getCreateTime())
                .build());
    }

    @Override
    public void add(ProductInfo productInfo) {
        productInfo.setId(IdWorker.getIdStr());
        productInfo.setCreateTime(TextUtil.now());
        productInfo.setUpdateTime(TextUtil.now());
        int i = productInfoMapper.insert(productInfo);
    }

    @Override
    public void addSome(List<ProductInfo> list) {
        List<ProductInfo> infos = list.stream().peek(v -> {
            v.setId(IdWorker.getIdStr());
            v.setCreateTime(TextUtil.now());
            v.setUpdateTime(TextUtil.now());
        }).collect(Collectors.toList());
        if (infos.size() > 0){
            productInfoMapper.insertBatch(infos);
        }
    }

    @Override
    public void down(String id) {

    }

    @Override
    public void downSome(List<String> ids) {

    }
}
