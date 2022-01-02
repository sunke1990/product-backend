package com.back.productbackend.service;

import com.back.productbackend.db.entity.SystemRole;
import com.back.productbackend.global.UserAuthentication;

/**
 * @author sunke
 * @DATE 2022/1/2
 **/
public interface RoleService {
    void addRole(SystemRole systemRole, UserAuthentication auth);
}
