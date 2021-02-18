package com.example.advice;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: http请求工具类
 * @Author: 乔伟亚
 * @Date: 2020/12/25 18:13
 * @Version: 1.0
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * @Description: 执行post请求，用于key-value格式的参数
     * @Param: [url：请求的url, map：请求的参数集合]
     * @return: java.lang.String
     * @Author: 乔伟亚
     * @Date: 2020/4/30
     */
    public static String doPostWithMap(String url, Map params) {
        String result = null;
        BufferedReader in = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));
            //设置参数
            List<NameValuePair> nvps = new ArrayList<>();
            for (Object o : params.keySet()) {
                String name = (String) o;
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }
            request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {    //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line).append(NL);
                }
                in.close();
                result = sb.toString();
            } else {
                logger.error("doPostWithMap 状态码：{}", statusCode);
            }
        } catch (Exception e) {
            logger.error("doPostWithMap Exception：{}", e);
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("doPostWithMap IOException：{}", e);
            }
        }
        return result;
    }

    /**
     * @Description: 执行get请求，用于key-value格式的参数
     * @Param: [url：请求的url, map：请求的参数集合]
     * @return: java.lang.String
     * @Author: 乔伟亚
     * @Date: 2020/4/30
     */
    public static String doGetWithMap(String url, Map<String, String> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            //创建uri
            URIBuilder builder = new URIBuilder(url);
            if (map != null) {
                for (String key : map.keySet()) {
                    builder.addParameter(key, map.get(key));
                }
            }
            URI uri = builder.build();
            //发送get请求
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
            //请求发送成功，并得到响应
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            } else {
                logger.error("doGetWithMap 状态码：{}", statusCode);
            }
        } catch (Exception e) {
            logger.error("doGetWithMap Exception：{}", e);
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("doGetWithMap IOException：{}", e);
            }
        }
        return result;
    }

    /**
     * @Description: 通过流的形式返回响应内容字符串
     * @Param: [requestUrl, requestMethod, outputStr]
     * @return: java.lang.String
     * @Author: 乔伟亚
     * @Date: 2020/4/27
     */
    public static String doRequestByStream(String requestUrl, String requestMethod, String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuilder buffer = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (Exception e) {
            logger.error("HTTPCLIENT {}", e);
        }
        return null;
    }

    /**
     * 用于发送json格式的post访问
     *
     * @param url
     * @param json
     * @return
     */
    public static String doPostWithJson(String url, String json) {
        return doPost(url, json, null);
    }

    public static String doPostWithJsonAndToken(String url, String json, String token) {
        return doPost(url, json, token);
    }

    private static String doPost(String url, String json, String token) {
        String result = "这是默认返回值，接口调用失败";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();
            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            if (!StringUtils.isEmpty(token)) {
                httpPost.setHeader("Authorization", token);
            }
            httpPost.setEntity(requestEntity);
            //第四步：发送HttpPost请求，获取返回值
            result = httpClient.execute(httpPost, responseHandler);

        } catch (Exception e) {
            logger.error("调用失败 url {} |  msg {}", url, e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
