package com.back.productbackend.service;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.global.UserAuthentication;

import java.util.List;

/**
 * @author sunke
 * @DATE 2022/1/3
 **/
public interface UserRoleService {
    void add(SystemUserRole systemUserRole);

    List<Integer> getRoles(UserAuthentication auth);
}
