/*
 * Copyright (C), 1970-2020,  David. Cor. Ltd.
 * FileName: ApiCache.java
 * Author:   davidwang2006@aliyun.com
 * Date:     2020-10-26 11:42:18
 * Description:
 */

package com.back.productbackend.aop;

import java.lang.annotation.*;

/**
 * ClassName: LimitCircuit
 *
 * 用于限流的注解
 *
 * @author: davidwang2006@aliyun.com DavidWang
 * @date: 2020/7/29 16:44
 * @description:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ApiCache {
    /**
     * 限流参考的key
     * 如果是@开头，则是取入参
     * @return
     */
    String value() default "#p0";

    /**
     * 用于组装redis key
     * @return
     */
    String prefix() default "cache:api";

    /**
     * 默认的过期时间
     * 即缓存多少时间
     * 默认10秒钟
     * @return
     */
    long expiration() default 10000;

}
