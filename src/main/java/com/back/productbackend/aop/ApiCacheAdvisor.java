/*
 * Copyright (C), 1970-2020,  David. Cor. Ltd.
 * FileName: ApiCacheAdvisor.java
 * Author:   davidwang2006@aliyun.com
 * Date:     2020-10-26 11:44:03
 * Description:
 */

package com.back.productbackend.aop;

import com.alibaba.fastjson.JSON;
import com.back.productbackend.utils.TextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.TimeUnit;

/**
 *
 * 缓存组件
 *
 * @author: davidwang2006@aliyun.com DavidWang
 * @date 2020-10-26 11:44:08
 * @description:
 */
@Component
@Slf4j
public class ApiCacheAdvisor extends AbstractPointcutAdvisor {

    @Autowired
    @Lazy
    private StringRedisTemplate redisTemplate;

    private Pointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(ApiCache.class);

    @Override
    public Pointcut getPointcut() {
        return pc;
    }

    @Override
    public MethodInterceptor getAdvice() {
        return (mi)->{

            Method method = mi.getMethod();

            //get the annotation
            ApiCache anno = method.getAnnotation(ApiCache.class);
            String prefix = anno.prefix();
            long expiration = anno.expiration();
            String v = anno.value();

            Parameter[] parameters = method.getParameters();
            Object[] args = mi.getArguments();

            StandardEvaluationContext ctx = new StandardEvaluationContext();
            for (int i = 0; i < parameters.length; i++) {
                ctx.setVariable(String.format("p%d",i), args[i]);
                ctx.setVariable(parameters[i].getName(), args[i]);
            }

            Object obj = TextUtil.PARSER.parseExpression(v).getValue(ctx);

            v = obj == null ? "" : String.valueOf(obj);


            String key = String.format("%s:%s.%s:%s",prefix, method.getDeclaringClass().getSimpleName(), method.getName(),v);
            String line = redisTemplate.opsForValue().<String>get(key);
            if(StringUtils.isEmpty(line)){
                Object rt = mi.proceed();
                if(rt != null){
                    redisTemplate.opsForValue().set(key, JSON.toJSONString(rt), expiration, TimeUnit.MILLISECONDS);
                }
                return rt;
            }
            log.debug("命中缓存, key={}, size={}", key, line.length());
            return JSON.parseObject(line,method.getGenericReturnType());
        };
    }

}
