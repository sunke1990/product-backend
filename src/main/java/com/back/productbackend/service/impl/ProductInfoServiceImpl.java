package com.back.productbackend.service.impl;


import com.back.productbackend.db.ProductInfo;
import com.back.productbackend.page.Pagination;
import com.back.productbackend.service.ProductInfoService;
import com.back.productbackend.service.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/27
 **/
@Service
@Slf4j
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ProductInfoServiceImpl implements ProductInfoService {

    @Override
    public ProductInfo findOne(String id) {
        return null;
    }

    @Override
    public Pagination<ProductVO> findAll() {
        return null;
    }

    @Override
    public void add(ProductInfo productInfo) {

    }

    @Override
    public void addSome(List<ProductInfo> productInfos) {

    }

    @Override
    public void down(String id) {

    }

    @Override
    public void downSome(List<String> ids) {

    }
}
