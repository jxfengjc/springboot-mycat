package com.example.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserException
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/4/16
 * @Version V1.0
 **/
public class UserException extends RuntimeException{
    UserExceptionEmum userExceptionEmum;

    public UserException(String message) {
        super(message);
    }

    public UserException( UserExceptionEmum userExceptionEmum) {
        this.userExceptionEmum = userExceptionEmum;
    }

    public static void main(String[] args) {
        int a =0;
        while (true){
            List aaa =new ArrayList(1000);
            aaa.add(1);
            System.out.println("1");
        }
    }
}
