package com.back.productbackend.global;

import com.back.productbackend.db.entity.User;
import com.back.productbackend.db.mapper.UserMapper;
import com.back.productbackend.utils.JWTUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunke
 * @DATE 2022/1/3
 **/
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String xId = request.getHeader("userId");
        long userId = Long.parseLong(xId);

        System.out.println(xId);

        boolean hasToken = redisTemplate.hasKey(xId);
        if (hasToken){
            return true;
        }
        User user = userMapper.queryById(userId);
        String token = JWTUtils.getToken(userId, user.getRealName());
        System.out.println("----------------------->token"+token);
        redisTemplate.opsForValue().set(xId,token);
        return true;
    }


}
