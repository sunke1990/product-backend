package com.back.productbackend.global;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.db.entity.User;
import com.back.productbackend.db.mapper.SystemUserRoleMapper;
import com.back.productbackend.db.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunke
 * @DATE 2021/12/31
 **/
@Component
@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SystemUserRoleMapper userRoleMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String x = request.getHeader("userId");
        long userId = Long.parseLong(x);
        User user = userMapper.queryById(userId);
        List<SystemUserRole> roles = userRoleMapper.queryAll(SystemUserRole.builder().userId(userId).build());
        SecurityContext context = SecurityContextHolder.getContext();
        UserAuthentication auth = UserAuthentication
                .builder()
                .user(user)
                .roles(roles)
                .build();
        context.setAuthentication(auth);
        return true;
    }


}
