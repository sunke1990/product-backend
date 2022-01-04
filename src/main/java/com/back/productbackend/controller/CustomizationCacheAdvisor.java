package com.back.productbackend.controller;

import com.alibaba.fastjson.JSON;
import com.back.productbackend.aop.CustomizationCache;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author sunke
 * @DATE 2022/1/4
 **/
@Component
@Slf4j
public class CustomizationCacheAdvisor extends AbstractPointcutAdvisor implements MethodInterceptor {

    @Resource
    @Lazy
    private StringRedisTemplate stringRedisTemplate;

    private final Pointcut point = AnnotationMatchingPointcut.forMethodAnnotation(CustomizationCache.class);

    @Override
    public Pointcut getPointcut() {
        return point;
    }

    @Override
    public MethodInterceptor getAdvice() {
        return this;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Parameter[] params = method.getParameters();
        Object[] args = invocation.getArguments();

        CustomizationCache annotation = method.getAnnotation(CustomizationCache.class);
        String value = annotation.value();
        String prefix = annotation.prefix();
        long expiration = annotation.expiration();

        StandardEvaluationContext ctx = new StandardEvaluationContext();
        for (int i = 0; i < params.length; i++) {
            ctx.setVariable(String.format("p%d", i), args[i]);
            ctx.setVariable(params[i].getName(),args[i]);
        }

        ExpressionParser parser = new SpelExpressionParser();
        Object result = parser.parseExpression(value).getValue(ctx);
        System.out.println("result" + result);
        String key = String.format("%s%s%s%s", prefix, method.getDeclaringClass(), method.getName(), result);
        System.out.println("key:"+key);
        String exist = stringRedisTemplate.opsForValue().get(key);

        if (!StringUtils.hasText(exist)){
            Object o = invocation.proceed();
            System.out.println(o);
            if (Objects.nonNull(o)){
                stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(o), expiration, TimeUnit.SECONDS);
            }
            return o;
        }
        return JSON.parseObject(exist,method.getGenericReturnType());
    }
}
