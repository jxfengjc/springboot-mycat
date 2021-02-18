package com.example.advice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdviceTestController
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/18
 * @Version V1.0
 **/
@RestController
@RequestMapping("advice")
public class AdviceTestController {
    @GetMapping("test")
    public String test(){
        int a =1/0;
        return "success";
    }
}
