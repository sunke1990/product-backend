package com.back.productbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author sunke
 * @DATE 2022/1/3
 **/
public class JWTUtils {
    private static final String SIGN = "c3Vua2Ug";

    public String getToken(Long userId,String realName){
        return JWT
                .create()
                .withAudience(String.valueOf(userId),realName)
                .withExpiresAt(new Date())
                .sign(Algorithm.HMAC256(SIGN));
    }
}
