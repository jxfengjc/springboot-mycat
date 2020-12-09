package com.example.drapdf;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName DrapDfUtil
 * @Description: 数据抓取工具类
 * @Author fengjc
 * @Date 2020/12/7
 * @Version V1.0
 **/
public class DrapDfUtil {
    public static String getResultByUrl(String urlStr,String CharsetName){
        try {
            URL url =new URL(urlStr);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");//GET和POST必须全大写
            conn.connect();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br =new BufferedReader(new InputStreamReader(is,CharsetName));
            StringBuffer sb =new StringBuffer();
            String str;
            while((str =br.readLine()) !=null){
                sb.append(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
