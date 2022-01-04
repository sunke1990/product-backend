package com.back.productbackend.aop;

import java.lang.annotation.*;
import java.security.Policy;

/**
 * @author sunke
 * @DATE 2022/1/4
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CustomizationCache {

    String value() default "#p0";

    String prefix() default "cache:api";

    long expiration() default 10000;
}
