package com.back.productbackend.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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

    Pointcut point = AnnotationMatchingPointcut.forMethodAnnotation(CustomizationCache.class);

    @Override
    public Pointcut getPointcut() {
        return point;
    }

    @Override
    public Advice getAdvice() {
        return this;
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
            ctx.setVariable(String.format("#p%d", i), args[i]);
        }

        ExpressionParser parser = new SpelExpressionParser();
        Object result = parser.parseExpression(value).getValue(value);
        String key = String.format("%s%s%s%s",prefix,method.getDeclaringClass(),method.getName(),result);
        Object o = invocation.proceed();

        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(o),expiration, TimeUnit.SECONDS);

        return invocation.proceed();
    }
}
