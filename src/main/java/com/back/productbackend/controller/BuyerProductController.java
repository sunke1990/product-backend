package com.back.productbackend.controller;

import com.back.productbackend.db.entity.ProductInfo;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.page.Pagination;
import com.back.productbackend.service.ProductInfoService;

import com.back.productbackend.db.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/27
 **/
@RestController
@RequestMapping("/buyer/product")
@Validated
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/detail")
    public BusinessResult<ProductInfo> detail(@RequestParam(value = "id",required = true) @NotEmpty String id){
        return BusinessResult.success(productInfoService.findOne(id));
    }


    @GetMapping("/list")
    public BusinessResult<Pagination<ProductVO>> list(
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "type", required = true) Integer type
    ){
        return BusinessResult.success(productInfoService.findAll(type, pageIndex, pageSize));
    }

    @DeleteMapping("/delete")
    public BusinessResult del(@RequestParam(value = "id",required = true) @NotEmpty String id){
        productInfoService.down(id);
        return BusinessResult.success(null);
    }

    @PostMapping("/add")
    public BusinessResult add(@RequestBody ProductInfo productInfo){
        productInfoService.add(productInfo);
        return BusinessResult.success(null);
    }

    @PostMapping("/addSome")
    public BusinessResult addSome(@RequestBody List<ProductInfo> list){
        productInfoService.addSome(list);
        return BusinessResult.success(null);
    }

    @PostMapping("/down")
    public BusinessResult down(@RequestParam(value = "id",required = true) @NotEmpty String id){
        productInfoService.down(id);
        return BusinessResult.success(null);
    }

    @PostMapping("/downSome")
    public BusinessResult downSome(@RequestBody List<String> ids){
        productInfoService.downSome(ids);
        return BusinessResult.success(null);
    }


}
