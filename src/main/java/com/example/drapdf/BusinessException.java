package com.example.drapdf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *  @author rpmcc
 *  Date 2018/9/14
 *  Description 统一异常处理
 *  Version v1.0.0
 */
public class BusinessException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    ResultEnum resultEnum ;
    public BusinessException(String message) {
        super(message);
        logger.error(message);
    }
    public BusinessException(ResultEnum resultEnum , String message){
        this.resultEnum =resultEnum;
        logger.error(message);
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
