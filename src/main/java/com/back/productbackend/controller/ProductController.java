package com.back.productbackend.controller;

import com.back.productbackend.db.entity.ProductInfo;
import com.back.productbackend.db.vo.ProductVO;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.page.Pagination;
import com.back.productbackend.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/29
 **/
@RestController
@Validated
@RequestMapping("/product")
public class ProductController {

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

    @GetMapping("/list")
    public BusinessResult<Pagination<ProductVO>> list(
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "type", required = false) Integer type
    ) {
        return BusinessResult.success(productInfoService.findAll(type, pageIndex, pageSize));
    }
}
