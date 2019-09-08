package com.meiziyu.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: Meiziyu
 * @Date: 2019/6/3 17:06
 * @Email 308348194@qq.com
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EnumValidtor.class)
public @interface   EnumValidAnnotation {
    Class<?> value();

    String message() default "入参值不在正确枚举中";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}