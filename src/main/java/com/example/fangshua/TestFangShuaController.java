package com.example.fangshua;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestFangShua
 * @Description: 接口防刷测试，使用自定义注解方式
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/fangshua")
public class TestFangShuaController {
    @AccessLimit(seconds = 5,maxCoint = 2,needLogin = false)
    @GetMapping("/test")
    public String test(){
        return "success test";
    }
    @GetMapping("/notTest")
    public String test2(){
        return "success test";
    }
}
