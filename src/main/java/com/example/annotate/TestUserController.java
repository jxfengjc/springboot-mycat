package com.example.annotate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName TestUserController
 * @Description: 参数校验与自定义注解
 * @Author fengjc
 * @Date 2020/12/30
 * @Version V1.0
 **/
@RestController
@RequestMapping("/validator")
public class TestUserController {
    @PostMapping("/test")
    public List<FieldError> testValidator(@RequestBody @Valid TestUserVo vo, BindingResult result){
        if(result.hasErrors()){
            return result.getFieldErrors();
        }
        return result.getFieldErrors();
    }
}
