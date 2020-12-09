package com.example.drapdf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestUrl
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/7
 * @Version V1.0
 **/
@RestController
public class TestUrl {
    @RequestMapping("/testUrl")
    public String test(){
        int page = 1;
        Date paramDate =new Date();
        String paramDateStr = DateUtil.format(paramDate, DateUtil.FORMAT_SHORT);
        String url = "http://dcfm.eastmoney.com/em_mutisvcexpandinterface/api/js/get?type=DZJYXQ&token=70f12f2f4f091e459a279469fe49eca5&cmd=&st=SECUCODE&sr=1&p=" + page + "&ps=50&js=var%20qZTiyhDw={pages:(tp),data:(x)}&filter=(Stype=%27EQA%27)(TDATE=^" + paramDateStr + "^)&rt=53235851";
        String result = DrapDfUtil.getResultByUrl(url, "UTF-8");
        System.out.println(result);
        result = result.substring(13, result.length());
        DFBigTrade dfBigTrade = JSONObject.parseObject(result, DFBigTrade.class);
        //获取东方财富数据的总页数
        int totalPage = dfBigTrade.getPages();
        //获取东方财富当天的总数据
        List<DFBigTrade.DataBean> totalData = new ArrayList<>();
        if (totalPage > 0) {
            //第一页的数据
            totalData.addAll(dfBigTrade.getData());
            //请求第二页之后的数据
            for (int i = page + 1; i <= totalPage; i++) {
                url = "http://dcfm.eastmoney.com/em_mutisvcexpandinterface/api/js/get?type=DZJYXQ&token=70f12f2f4f091e459a279469fe49eca5&cmd=&st=SECUCODE&sr=1&p=" + i + "&ps=50&js=var%20qZTiyhDw={pages:(tp),data:(x)}&filter=(Stype=%27EQA%27)(TDATE=^" + paramDateStr + "^)&rt=53235851";
                result = DrapDfUtil.getResultByUrl(url, "UTF-8");
                System.out.println(result);
                if (StringUtils.isEmpty(result)) {
                    continue;
                }
                result = result.substring(13, result.length());
                dfBigTrade = JSONObject.parseObject(result, DFBigTrade.class);
                if (dfBigTrade != null && dfBigTrade.getData().size() > 0) {
                    totalData.addAll(dfBigTrade.getData());
                }
            }
        }
        return result;
    }
}
