package com.back.productbackend.controller;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunke
 * @DATE 2022/1/3
 **/
@RestController
@Validated
@RequestMapping("/user/role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/add")
    public BusinessResult add(@RequestBody SystemUserRole systemUserRole){
        userRoleService.add(systemUserRole);
        return BusinessResult.success(null);
    }

}
