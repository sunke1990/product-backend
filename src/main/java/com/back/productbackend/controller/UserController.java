package com.back.productbackend.controller;

import com.back.productbackend.db.entity.User;
import com.back.productbackend.global.UserAuthentication;
import com.back.productbackend.page.BusinessResult;
import com.back.productbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunke
 * @DATE 2022/1/2
 **/
@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BusinessResult login(@RequestBody User user){
        userService.login(user);
        return BusinessResult.success(null);
    }
}
