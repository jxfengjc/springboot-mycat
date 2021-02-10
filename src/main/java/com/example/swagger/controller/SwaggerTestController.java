package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SwaggerTestController
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/10
 * @Version V1.0
 **/
@RestController
@Api(value = "swagger测试", tags = "swagger测试")
@RequestMapping("swagger")
public class SwaggerTestController {
    @ApiOperation(value = "test测试")
    @GetMapping("test")
    public String test() {
        return "testSuccess";
    }
}
