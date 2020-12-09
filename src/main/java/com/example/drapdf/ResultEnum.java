package com.example.drapdf;

/**
 * @author   rpmcc
 * Date     2018/9/14
 * Description  返回信息枚举
 * Version v1.0.0
 */
public enum ResultEnum {
    SUCCESS(200, "处理成功"),
    EXCEPTION(500, "系统异常"),
    EXCEPIRED(501,"登录超时，请重新登录！"),
    BADTOKEN(401,"请先登录"),
    BANUSER(502, "您的帐号被封禁，请联系客服");
    private Integer code;
    private String desc;


    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
