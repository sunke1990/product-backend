package com.back.productbackend.service.impl;

import com.back.productbackend.db.entity.SystemRole;
import com.back.productbackend.db.mapper.SystemRoleMapper;
import com.back.productbackend.global.UserAuthentication;
import com.back.productbackend.service.RoleService;
import com.back.productbackend.utils.TextUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sunke
 * @DATE 2022/1/2
 **/
@Service
@Slf4j
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class RoleServiceImpl implements RoleService {

    @Resource
    private SystemRoleMapper roleMapper;

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void addRole(SystemRole systemRole, UserAuthentication auth) {
        systemRole.setId(IdWorker.getIdStr());
        systemRole.setCreateTime(TextUtil.now());
        systemRole.setUpdateTime(TextUtil.now());
        roleMapper.insert(systemRole);
    }
}
