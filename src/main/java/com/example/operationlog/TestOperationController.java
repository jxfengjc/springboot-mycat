package com.example.operationlog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestOperationController
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/9
 * @Version V1.0
 **/
@RestController
public class TestOperationController {
    @OperationLog(operateName = "测试操作日志保存",content = "测试操作日志保存")
    @RequestMapping("/testOperation")
    public String testOperation(String name){
        return name;
    }
}
