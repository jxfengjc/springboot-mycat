package com.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AopTestController
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/9
 * @Version V1.0
 **/
@RestController
@RequestMapping("aop")
public class AopTestController {
    @Autowired
    private TargetClass targetClass;
    @GetMapping("test")
    public String test(){
        String joint = targetClass.joint("test1", "test2");
        return joint;
    }
    @GetMapping("throw")
    public String throwTest() throws ArithmeticException{
        try {
            int a =1/0;
        }catch (Exception e){

        }
        return "success";
    }
}
