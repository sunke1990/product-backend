package com.back.productbackend.controller;

import com.back.productbackend.db.model.ProductInfo;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/29
 **/
@RestController
@Validated
@RequestMapping("/shop/product")
public class ShopController {

    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/add")
    public BusinessResult add(@RequestBody ProductInfo productInfo){
        productInfoService.add(productInfo);
        return BusinessResult.success(null);
    }

    @PostMapping("/addSome")
    public BusinessResult addSome(@RequestBody List<ProductInfo> list) {
        productInfoService.addSome(list);
        return BusinessResult.success(null);
    }
}
