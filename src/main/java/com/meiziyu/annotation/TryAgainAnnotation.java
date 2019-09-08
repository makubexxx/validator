package com.meiziyu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: Meiziyu
 * @Date: 2019/8/7 16:49
 * @Email 308348194@qq.com
 * 重试注解（异常重试，乐观锁更新失败重试）
 */
@Target(ElementType.METHOD)
public @interface TryAgainAnnotation {
    /**
     * 重试次数
     * @return
     */
    int tryTimes() default 3;
}
