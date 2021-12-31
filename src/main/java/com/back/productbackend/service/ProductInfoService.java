package com.back.productbackend.service;

import com.back.productbackend.db.entity.ProductInfo;
import com.back.productbackend.db.vo.ProductVO;
import com.back.productbackend.page.Pagination;


import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/27
 **/

public interface ProductInfoService {

    ProductInfo findOne(String id);

    Pagination<ProductVO> findAll(Integer type, Integer pageIndex, Integer pageSize);

    void add(ProductInfo productInfo);

    void addSome(List<ProductInfo> productInfos);

    void down(String id);

    void downSome(List<String> ids);


}
