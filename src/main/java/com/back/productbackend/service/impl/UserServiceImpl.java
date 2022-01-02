package com.back.productbackend.service.impl;

import com.back.productbackend.db.entity.User;
import com.back.productbackend.db.mapper.UserMapper;
import com.back.productbackend.service.UserService;
import com.back.productbackend.utils.TextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void login(User user) {
        user.setCreateTime(TextUtil.now());
        user.setUpdateTime(TextUtil.now());
        userMapper.insert(user);

    }
}
