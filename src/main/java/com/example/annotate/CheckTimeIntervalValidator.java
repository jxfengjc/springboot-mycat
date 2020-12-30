package com.example.annotate;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * @ClassName CheckTimeIntervalValidator
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/30
 * @Version V1.0
 **/
public class CheckTimeIntervalValidator implements ConstraintValidator<CheckTimeInterval,Object> {
    private String startTime;
    private String endTime;
    @Override
    public void initialize(CheckTimeInterval constraintAnnotation) {
        this.startTime =constraintAnnotation.startTime();
        this.endTime =constraintAnnotation.endTime();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(null == value){
            return true;
        }
        //使用beamWrapper来获取属性值
        BeanWrapper beanWrapper =new BeanWrapperImpl(value);
        Object start =beanWrapper.getPropertyDescriptor(startTime);
        Object end =beanWrapper.getPropertyDescriptor(endTime);
        if(null ==start || null ==end){
            return true;
        }
        int resylt =((Date)start).compareTo((Date)end);
        if(resylt >0){
            return true;
        }
        return false;
    }
}
