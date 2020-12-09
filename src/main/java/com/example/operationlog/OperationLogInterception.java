package com.example.operationlog;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.security.x509.IPAddressName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName OperationLogInterception
 * @Description: 操作日志(OperationLog 注解) 拦截处理
 * @Author fengjc
 * @Date 2020/12/9
 * @Version V1.0
 **/
@Component
public class OperationLogInterception implements HandlerInterceptor {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public static final String LOG_TOPIC = "logTopic";
    @Autowired
    private  StringRedisTemplate stringRedisTemplate;

    public OperationLogInterception(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            //获取Log自定义注解
            HandlerMethod method = (HandlerMethod) handler;
            OperationLog log =method.getMethodAnnotation(OperationLog.class);
            if(log !=null){
                //模块名称
                String operateName = log.operateName();
                //操作内容
                String content = log.content();

                String contentType = request.getHeader("Content-Type");
                StringBuffer requestURL =request.getRequestURL();
                String jsonStr =null;

                if(null !=contentType){
                    //获取请求参数
                    if(contentType.contains("application/x-www-form-urlencoded")){
                        Map<String, String[]> requestParamMap = request.getParameterMap();
                        jsonStr = JSON.toJSONString(requestParamMap);
                    }else if(contentType.contains("application/json")){
                        RequstWrapper rw = (RequstWrapper)request;
                        jsonStr = rw.getStringCatch();
                    }
                }
                JSONObject obj ;
                if(StringUtils.isEmpty(jsonStr)){
                    obj =new JSONObject();
                }else {
                   obj =JSONObject.parseObject(jsonStr);
                }
                obj.put("requestURL",requestURL);
                jsonStr =JSONObject.toJSONString(obj);

                String remoteAddr = IPUtil.getIpAddr(request);
                //操作日期
                Date operateDate = new Date();
                //TODO 获取操作者
                String operateId ="";
                //定义json字符串
                SystemLog systemLog = new SystemLog();
                if(!StringUtils.isEmpty(operateId)){
                    systemLog.setFkAuId(Long.parseLong(operateId));
                }
                systemLog.setOperateTime(operateDate);
                systemLog.setSlIp(remoteAddr);
                systemLog.setSlContent(content);
                systemLog.setSlOperateName(operateName);
                systemLog.setSlParams(jsonStr);
                String json = JSON.toJSONString(systemLog);
                //日志输出
                logger.info(json);
                //存入redis
                stringRedisTemplate.opsForList().leftPush(LOG_TOPIC,json);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
