package com.example.operationlog;


import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * ip 相关工具类
 *
 * @author duyang
 * @date 2018-08-15 16:11
 */
public class IPUtil {
    private static final Logger logger = LogManager.getLogger(IPUtil.class);
    private static String localIpAddress = null;

    private static CloseableHttpClient httpClient;

    private static final String BAI_DU_KEY = "TBkRu9XDlwqs57QK1pON1gVsUuUkdkO3";

    static {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(20);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(2);
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(3000).build();
        poolingHttpClientConnectionManager.setDefaultSocketConfig(socketConfig);
        httpClient = HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager).build();
    }

    public IPUtil() {
    }

    /**
     * @Author dubl
     * @Description 获取访问请求来源的ip
     * @Date 2019/6/14 16:11
     * @Param [request]
     * @return java.lang.String
     **/
    public static String getIpAddr(HttpServletRequest request) {
        //nginx 代理
        String xIp = request.getHeader("X-Real-IP");
        String xFor = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(xFor) && !"unKnown".equalsIgnoreCase(xFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if(index != -1){
                return xFor.substring(0,index);
            }else{
                return xFor;
            }
        }

        xFor = xIp;
        if(!StringUtils.isEmpty(xFor) && !"unKnown".equalsIgnoreCase(xFor)){
            return xFor;
        }
        if (StringUtils.isEmpty(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getRemoteAddr();
        }
        return xFor;
    }

    /**
     * 通过IP地址获取MAC地址
     * @param ip String,127.0.0.1格式
     * @return mac String
     * @throws Exception
     */
    public static String getMACAddress(String ip) {
        String line = "";
        String macAddress = "";
        final String MAC_ADDRESS_PREFIX = "MAC Address = ";
        final String LOOPBACK_ADDRESS = "127.0.0.1";
        //如果为127.0.0.1,则获取本地MAC地址。
        try{
            if (LOOPBACK_ADDRESS.equals(ip)) {
                InetAddress inetAddress = InetAddress.getLocalHost();
                //貌似此方法需要JDK1.6。
                byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                //下面代码是把mac地址拼装成String
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    if (i != 0) {
                        sb.append("-");
                    }
                    //mac[i] & 0xFF 是为了把byte转化为正整数
                    String s = Integer.toHexString(mac[i] & 0xFF);
                    sb.append(s.length() == 1 ? 0 + s : s);
                }
                //把字符串所有小写字母改为大写成为正规的mac地址并返回
                macAddress = sb.toString().trim().toUpperCase();
                return macAddress;
            }
            //获取非本地IP的MAC地址
            try {
                Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
                InputStreamReader isr = new InputStreamReader(p.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                while ((line = br.readLine()) != null) {
                    if (line != null) {
                        int index = line.indexOf(MAC_ADDRESS_PREFIX);
                        if (index != -1) {
                            macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
                        }
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }catch (Exception e){
            logger.error("according ip get mac error{}",e);
        }
        return macAddress;
    }


    /**
     * 百度 IP定位API <br>
     * 每个key每天支持10万次调用，超过限制不返回数据。<br>
     * IP定位的结果精度较差，主要应用获取省份或者城市的位置信息。移动平台的APP建议使用百度定位SDK 。
     *
     * @param ip   ip地址
     * @param ak   用户密钥 (必选，在lbs云官网注册的access key，作为访问的依据)
     * @param sn   用户的权限签名 (可选，若用户所用ak的校验方式为sn校验时该参数必须。)
     * @param coor 输出的坐标格式 (可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标)
     * @return 地址解析
     */
    public static IpResult baiduParseIP(String ip, String ak, String sn, String coor) {
        HttpUriRequest httpUriRequest = RequestBuilder.post().setUri("http://api.map.baidu.com/location/ip")
            .addParameter("ip", ip).addParameter("ak", ak == null ? "" : ak)
            .addParameter("sn", sn == null ? "" : sn).addParameter("coor", coor == null ? "" : coor).build();

        try {
            CloseableHttpResponse response = httpClient.execute(httpUriRequest);
            String json = EntityUtils.toString(response.getEntity(), "utf-8");
            response.close();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, IpResult.class);
        } catch (Exception e) {
            logger.error("IPUTIL {}",e);
        }

        return null;
    }

    /**
     * 百度 IP定位API
     *
     * @param ip
     * @return
     */
    public static IpResult baiduParseIP(String ip) {
        return baiduParseIP(ip, BAI_DU_KEY, null, null);
    }

    public static class IpResult {

        private String status;

        private String address;

        private Content content;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public boolean isSuccess() {
            return "0".equals(status);
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

    }

    public static class Content {
        private String address;

        private AddressDetail address_detail;

        private Point point;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressDetail getAddress_detail() {
            return address_detail;
        }

        public void setAddress_detail(AddressDetail address_detail) {
            this.address_detail = address_detail;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

    }

    public static class AddressDetail {

        private String city;
        private String city_code;
        private String district;
        private String province;
        private String street;
        private String street_number;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

    }

    public static class Point {

        private String x;

        private String y;

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }

    }

}
