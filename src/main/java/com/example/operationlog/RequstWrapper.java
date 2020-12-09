package com.example.operationlog;

import io.netty.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * @ClassName RequstWrapper
 * @Description 自定义 requst 包装器
 * @Author dubl
 * @Date 2019/3/20 11:21
 **/
public class RequstWrapper extends HttpServletRequestWrapper {

    /**
     * 输入流存储容器
     */
    private final byte[] cache;

    private final Logger logger = LogManager.getLogger(this.getClass());


    public RequstWrapper(HttpServletRequest request) {
        super(request);

        cache = getStringCatchByRequest(request);
    }

    /**
     * @Author dubl
     * @Description 通过requst获取 byte[]
     * @Date 2019/3/20 12:39
     * @Param [request]
     * @return java.lang.String
     **/
    private byte[] getStringCatchByRequest(final HttpServletRequest request){
        try {
            return this.inputStreamToString(request.getInputStream()).getBytes(CharsetUtil.UTF_8);
        } catch (IOException e) {
            logger.error("",e);
        }

        return null;
    }

    /**
     * @Author dubl
     * @Description 获取缓存中的字符串
     * @Date 2019/3/20 12:41
     * @Param []
     * @return java.lang.String
     **/
    public String getStringCatch(){
        final InputStream inputStream = new ByteArrayInputStream(cache);

        return inputStreamToString(inputStream);
    }

    /**
     * @Author dubl
     * @Description 输入流转字符串
     * @Date 2019/3/20 12:35
     * @Param [inputStream]
     * @return java.lang.String
     **/
    private String inputStreamToString(InputStream inputStream){

        StringBuilder sb = new StringBuilder();
        BufferedReader reader;
        try {

            reader = new BufferedReader(new InputStreamReader(inputStream, CharsetUtil.UTF_8));
            String line;
            while (null != (line = reader.readLine())){
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error("",e);
        }

        return sb.toString();
    }

   /**
    * @Author dubl
    * @Description 重写reader，改为从缓存里获取
    * @Date 2019/3/20 12:34
    * @Param []
    * @return java.io.BufferedReader
    **/
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * @Author dubl
     * @Description 重写InputStream，改为从缓存里获取
     * @Date 2019/3/20 12:34
     * @Param []
     * @return javax.servlet.ServletInputStream
     **/
    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream inputStream = new ByteArrayInputStream(cache);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return inputStream.read();
            }
        };

    }
}
