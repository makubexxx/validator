package com.meiziyu.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @Author: Meiziyu
 * @Date: 2019/3/13 10:41
 * @Email 308348194@qq.com
 */
public class MzyValidator   {
    private Validator validator;

    public MzyValidator() {

        this.validator= Validation.buildDefaultValidatorFactory().getValidator();

    }

    public  ValidationResult validate(Object bean)
    {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet= validator.validate(bean);
        if (constraintViolationSet.size()>0)
        {
            result.setHasError(true);
            constraintViolationSet.forEach(constraintViolation->{
                String errMsg=constraintViolation.getMessage();
                String propertyName=constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName,errMsg);
            });
        }

        return  result;
    }

}
