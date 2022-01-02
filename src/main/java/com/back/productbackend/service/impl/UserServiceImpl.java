package com.back.productbackend.service.impl;

import com.back.productbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunke
 * @DATE 2022/1/2
 **/
@Service
@Slf4j
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
}
