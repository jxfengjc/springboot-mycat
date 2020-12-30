package com.example.annotate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @ClassName CheckTimeInterval
 * @Description: 自定义注解进行参数校验  比较两个时间，endtime要大于starttime
 * @Author fengjc
 * @Date 2020/12/30
 * @Version V1.0
 **/
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckTimeIntervalValidator.class)
@Documented
public @interface CheckTimeInterval {
    String startTime() default "from";
    String endTime() default "to";
    String message() default "时间传输错误";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    @Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        CheckTimeInterval[] value();
    }
}
