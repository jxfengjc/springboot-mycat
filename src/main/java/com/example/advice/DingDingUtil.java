package com.example.advice;

/**
 * @Description: 钉钉通知工具类
 * @Author: 乔伟亚
 * @Date: 2020/12/25 18:12
 * @Version: 1.0
 */
public class DingDingUtil {

    private static String devUrl;
    private static String proUrl;

    static {
        devUrl = "https://oapi.dingtalk.com/robot/send?access_token=9edaad9b2fed0a6b9c9c7d35176c14da13f724dfcec782cad884960d17669730";
        proUrl = "https://oapi.dingtalk.com/robot/send?access_token=9edaad9b2fed0a6b9c9c7d35176c14da13f724dfcec782cad884960d17669730";
    }

    /**
     * 钉钉发送异常信息
     *
     * @param env
     * @param name
     * @param msg
     */
    public static void sendExceptionMsg(String env, String name, String msg) {
        String content = "name=" + name + " msg=" + msg;
        String url = devUrl;
        if ("pro".equals(env)) {
            url = proUrl;
        }
        HttpUtil.doPostWithJson(url, "{" +
                "\"msgtype\": \"text\"," +
                "\"text\": {" +
                "\t\"content\": \"" + content + "\"" +
                "}" +
                "}");

    }
}
