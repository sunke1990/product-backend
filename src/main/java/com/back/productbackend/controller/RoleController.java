package com.back.productbackend.controller;

import com.back.productbackend.db.entity.SystemRole;
import com.back.productbackend.global.UserAuthentication;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunke
 * @DATE 2022/1/1
 **/
@RestController
@Validated
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public BusinessResult addRole(
            @RequestBody SystemRole systemRole,
            @AuthenticationPrincipal UserAuthentication auth
            ){
        roleService.addRole(systemRole,auth);
        return BusinessResult.success(null);
    }
}
