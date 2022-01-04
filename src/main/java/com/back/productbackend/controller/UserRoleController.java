package com.back.productbackend.controller;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.global.UserAuthentication;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/roles")
    public BusinessResult<List<Integer>> getRoles(@AuthenticationPrincipal UserAuthentication auth){

        return BusinessResult.success(userRoleService.getRoles(auth.getPrincipal().getId(),auth));
    }



}
