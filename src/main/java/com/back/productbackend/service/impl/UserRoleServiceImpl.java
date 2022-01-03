package com.back.productbackend.service.impl;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.db.mapper.SystemUserRoleMapper;
import com.back.productbackend.global.UserAuthentication;
import com.back.productbackend.service.UserRoleService;
import com.back.productbackend.utils.TextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunke
 * @DATE 2022/1/3
 **/
@Service
@Slf4j
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private SystemUserRoleMapper userRoleMapper;

    @Resource
    private StringRedisTemplate redisTemplate;

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void add(SystemUserRole systemUserRole) {
        systemUserRole.setCreateTime(TextUtil.now());
        systemUserRole.setUpdateTime(TextUtil.now());
        userRoleMapper.insert(systemUserRole);
        log.info("添加用户:{}为店铺:{}管理员:{}",systemUserRole.getUserId(),systemUserRole.getShopId(),systemUserRole.getRoleId());
    }

    @Override
    public List<Integer> getRoles(UserAuthentication auth) {
        List<SystemUserRole> roles = auth.getRoles();
        System.out.println(roles);
        return roles.stream().map(SystemUserRole::getRoleId).map(v -> Integer.parseInt(v.toString())).collect(Collectors.toList());
    }
}
