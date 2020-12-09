package com.example.drapdf;

import java.util.List;

/**
 * @Description: 大宗交易数据
 * @Author: 乔伟亚
 * @Date: 2020/8/11 0:25
 * @Version: 1.0
 */
public class DFBigTrade {

    /**
     * pages : 2
     * data : [{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000547","SNAME":"航天发展","PRICE":20.7,"TVOL":15.22,"TVAL":315.05,"BUYERCODE":"80166178","BUYERNAME":"广发证券佛山岭南大道北证券营业部","SALESCODE":"80141030","SALESNAME":"平安证券深圳深南东路罗湖商务中心证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-3.1053,"CPRICE":19.97,"YSSLTAG":1.205405063E9,"Zyl":0.0365548322483726,"Cjeltszb":1.30878529803965E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000599","SNAME":"青岛双星","PRICE":5.09,"TVOL":180.5,"TVAL":918.75,"BUYERCODE":"80035569","BUYERNAME":"海通证券青岛湛山一路证券营业部","SALESCODE":"80032735","SALESNAME":"中信证券徐州解放南路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.7682,"CPRICE":5.18,"YSSLTAG":7.67689142E8,"Zyl":-0.0173745173745173,"Cjeltszb":0.00231037349835104,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000606","SNAME":"顺利办","PRICE":4.1,"TVOL":650,"TVAL":2665,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80034130","SALESNAME":"国泰君安证券天津滨海新区福州道证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.4464,"CPRICE":4.5,"YSSLTAG":7.07201606E8,"Zyl":-0.088888888888889,"Cjeltszb":0.0083741639894158,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000661","SNAME":"长春高新","PRICE":488.5,"TVOL":4.75,"TVAL":2320.38,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80664214","SALESNAME":"中信建投证券邯郸人民东路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.8901,"CPRICE":488.5,"YSSLTAG":3.4002964E8,"Zyl":0,"Cjeltszb":1.39694005364195E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000813","SNAME":"德展健康","PRICE":7.2,"TVOL":350,"TVAL":2520,"BUYERCODE":"80453399","BUYERNAME":"长城证券广东分公司","SALESCODE":"ff0befd7875c8a161b6aafff2eb3405f","SALESNAME":"机构专用","Stype":"EQA","Unit":"万股","RCHANGE":-0.7452,"CPRICE":6.66,"YSSLTAG":2.24148045E9,"Zyl":0.0810810810810811,"Cjeltszb":0.00168807351578007,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000877","SNAME":"天山股份","PRICE":19.82,"TVOL":15,"TVAL":297.3,"BUYERCODE":"80033288","BUYERNAME":"中信建投证券上海中山南二路证券营业部","SALESCODE":"80033287","SALESNAME":"中信建投证券上海长宁天山西路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":9.9889,"CPRICE":19.82,"YSSLTAG":8.80094899E8,"Zyl":0,"Cjeltszb":1.70436165657176E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"000915","SNAME":"山大华特","PRICE":31.7,"TVOL":11.03,"TVAL":349.65,"BUYERCODE":"80166178","BUYERNAME":"广发证券佛山岭南大道北证券营业部","SALESCODE":"80141030","SALESNAME":"平安证券深圳深南东路罗湖商务中心证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-3.1269,"CPRICE":31.91,"YSSLTAG":2.33432457E8,"Zyl":-0.00658100908806014,"Cjeltszb":4.6940259604174E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002074","SNAME":"国轩高科","PRICE":26.2,"TVOL":43.45,"TVAL":1138.39,"BUYERCODE":"80998230","BUYERNAME":"长城证券绍兴金柯桥大道营业部","SALESCODE":"80998230","SALESNAME":"长城证券绍兴金柯桥大道营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.3054,"CPRICE":25.61,"YSSLTAG":1.096290953E9,"Zyl":0.023037875829754,"Cjeltszb":4.05467139751201E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002228","SNAME":"合兴包装","PRICE":4.8,"TVOL":54,"TVAL":259.2,"BUYERCODE":"80998230","BUYERNAME":"长城证券绍兴金柯桥大道营业部","SALESCODE":"80998230","SALESNAME":"长城证券绍兴金柯桥大道营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.2165,"CPRICE":4.63,"YSSLTAG":1.165484764E9,"Zyl":0.0367170626349891,"Cjeltszb":4.80338509017947E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002241","SNAME":"歌尔股份","PRICE":37.98,"TVOL":13,"TVAL":493.74,"BUYERCODE":"80147631","BUYERNAME":"中泰证券昌邑北海路证券营业部","SALESCODE":"80147631","SALESNAME":"中泰证券昌邑北海路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-1.605,"CPRICE":38.01,"YSSLTAG":2.720897515E9,"Zyl":-7.89265982636178E-4,"Cjeltszb":4.77406424557146E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002241","SNAME":"歌尔股份","PRICE":38.01,"TVOL":10,"TVAL":380.1,"BUYERCODE":"80035327","BUYERNAME":"中信建投证券北京丹棱街证券营业部","SALESCODE":"ff0befd7875c8a161b6aafff2eb3405f","SALESNAME":"机构专用","Stype":"EQA","Unit":"万股","RCHANGE":-1.605,"CPRICE":38.01,"YSSLTAG":2.720897515E9,"Zyl":0,"Cjeltszb":3.67525786799067E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002390","SNAME":"信邦制药","PRICE":5,"TVOL":40.72,"TVAL":203.6,"BUYERCODE":"80035529","BUYERNAME":"海通证券杭州解放路证券营业部","SALESCODE":"80035529","SALESNAME":"海通证券杭州解放路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.2,"CPRICE":5.06,"YSSLTAG":1.558471684E9,"Zyl":-0.0118577075098814,"Cjeltszb":2.58183414965386E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002466","SNAME":"天齐锂业","PRICE":25.2,"TVOL":37.89,"TVAL":954.83,"BUYERCODE":"80998230","BUYERNAME":"长城证券绍兴金柯桥大道营业部","SALESCODE":"80998230","SALESNAME":"长城证券绍兴金柯桥大道营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.3275,"CPRICE":24.51,"YSSLTAG":1.477099383E9,"Zyl":0.0281517747858016,"Cjeltszb":2.6373819388415E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002506","SNAME":"协鑫集成","PRICE":4.31,"TVOL":357,"TVAL":1538.67,"BUYERCODE":"80035310","BUYERNAME":"中信建投证券上海浦东新区福山路证券营业部","SALESCODE":"80172567","SALESNAME":"方正证券上海杨高南路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":9.949,"CPRICE":4.31,"YSSLTAG":5.073939908E9,"Zyl":0,"Cjeltszb":7.03595246441772E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002594","SNAME":"比亚迪","PRICE":81.98,"TVOL":3.5,"TVAL":286.93,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80460361","SALESNAME":"恒泰证券上海兰花路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-3.9822,"CPRICE":81.98,"YSSLTAG":1.141626029E9,"Zyl":0,"Cjeltszb":3.06580255801088E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002835","SNAME":"同为股份","PRICE":21.58,"TVOL":70,"TVAL":1510.6,"BUYERCODE":"80190852","BUYERNAME":"华泰证券深圳深南大道证券营业部","SALESCODE":"80190852","SALESNAME":"华泰证券深圳深南大道证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":9.9898,"CPRICE":21.58,"YSSLTAG":1.17256562E8,"Zyl":0,"Cjeltszb":0.00596981514774414,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"002957","SNAME":"科瑞技术","PRICE":22.66,"TVOL":22,"TVAL":498.52,"BUYERCODE":"80034523","BUYERNAME":"申万宏源证券北京安定路证券营业部","SALESCODE":"80033546","SALESNAME":"中泰证券北京苏州桥证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.6751,"CPRICE":25.35,"YSSLTAG":1.53887203E8,"Zyl":-0.106114398422091,"Cjeltszb":0.00127791543749833,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300014","SNAME":"亿纬锂能","PRICE":53.25,"TVOL":5,"TVAL":266.25,"BUYERCODE":"80035327","BUYERNAME":"中信建投证券北京丹棱街证券营业部","SALESCODE":"ff0befd7875c8a161b6aafff2eb3405f","SALESNAME":"机构专用","Stype":"EQA","Unit":"万股","RCHANGE":-1.9698,"CPRICE":53.25,"YSSLTAG":1.776825272E9,"Zyl":0,"Cjeltszb":2.81400770170946E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300033","SNAME":"同花顺","PRICE":141.83,"TVOL":1.52,"TVAL":215.58,"BUYERCODE":"80357508","BUYERNAME":"中信证券北京总部证券营业部","SALESCODE":"80398547","SALESNAME":"华创证券上海东方路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.8748,"CPRICE":141.83,"YSSLTAG":2.68887618E8,"Zyl":0,"Cjeltszb":5.65287732545874E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300059","SNAME":"东方财富","PRICE":26.5,"TVOL":38.4,"TVAL":1017.6,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80664214","SALESNAME":"中信建投证券邯郸人民东路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-1.5967,"CPRICE":26.5,"YSSLTAG":6.547336093E9,"Zyl":0,"Cjeltszb":5.86498072720826E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300109","SNAME":"新开源","PRICE":16.07,"TVOL":227,"TVAL":3647.89,"BUYERCODE":"80032252","BUYERNAME":"国信证券深圳振华路证券营业部","SALESCODE":"80393113","SALESNAME":"光大证券长沙人民中路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":3.8634,"CPRICE":18.55,"YSSLTAG":2.86190841E8,"Zyl":-0.133692722371968,"Cjeltszb":0.00687135029669113,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300122","SNAME":"智飞生物","PRICE":160.18,"TVOL":2,"TVAL":320.36,"BUYERCODE":"80033289","BUYERNAME":"中信建投证券上海控江路证券营业部","SALESCODE":"ff0befd7875c8a161b6aafff2eb3405f","SALESNAME":"机构专用","Stype":"EQA","Unit":"万股","RCHANGE":-0.5402,"CPRICE":160.18,"YSSLTAG":9.00369025E8,"Zyl":0,"Cjeltszb":2.22131142283576E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300131","SNAME":"英唐智控","PRICE":5.63,"TVOL":480,"TVAL":2702.4,"BUYERCODE":"80090933","BUYERNAME":"广发证券宁波丽园北路证券营业部","SALESCODE":"80923226","SALESNAME":"申港证券浙江分公司","Stype":"EQA","Unit":"万股","RCHANGE":5.1118,"CPRICE":6.58,"YSSLTAG":7.87815026E8,"Zyl":-0.144376899696049,"Cjeltszb":0.00521314108758693,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300136","SNAME":"信维通信","PRICE":60.19,"TVOL":51,"TVAL":3069.69,"BUYERCODE":"80398629","BUYERNAME":"湘财证券上海陆家嘴证券营业部","SALESCODE":"80398629","SALESNAME":"湘财证券上海陆家嘴证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-7.6425,"CPRICE":55.59,"YSSLTAG":8.11590087E8,"Zyl":0.0827486958085986,"Cjeltszb":6.80394997065046E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300146","SNAME":"汤臣倍健","PRICE":25.43,"TVOL":29.8,"TVAL":757.81,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80664214","SALESNAME":"中信建投证券邯郸人民东路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.72,"CPRICE":25.43,"YSSLTAG":8.92686633E8,"Zyl":0,"Cjeltszb":3.33821988633563E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300180","SNAME":"华峰超纤","PRICE":7.38,"TVOL":132.46,"TVAL":977.59,"BUYERCODE":"80035850","BUYERNAME":"中国银河证券中山证券营业部","SALESCODE":"80035850","SALESNAME":"中国银河证券中山证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-1.0724,"CPRICE":7.38,"YSSLTAG":1.341297392E9,"Zyl":0,"Cjeltszb":9.87586872514373E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300253","SNAME":"卫宁健康","PRICE":19.71,"TVOL":405.3,"TVAL":7988.46,"BUYERCODE":"80329404","BUYERNAME":"中邮证券汉中西环路证券营业部","SALESCODE":"80398405","SALESNAME":"东方证券交易单元(225900)","Stype":"EQA","Unit":"万股","RCHANGE":-0.5023,"CPRICE":21.79,"YSSLTAG":1.726596066E9,"Zyl":-0.0954566314823313,"Cjeltszb":0.00212331822596877,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300253","SNAME":"卫宁健康","PRICE":19.71,"TVOL":173.55,"TVAL":3420.67,"BUYERCODE":"80329404","BUYERNAME":"中邮证券汉中西环路证券营业部","SALESCODE":"80398405","SALESNAME":"东方证券交易单元(225900)","Stype":"EQA","Unit":"万股","RCHANGE":-0.5023,"CPRICE":21.79,"YSSLTAG":1.726596066E9,"Zyl":-0.0954566314823313,"Cjeltszb":9.09207901901566E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300254","SNAME":"仟源医药","PRICE":6.82,"TVOL":50,"TVAL":341,"BUYERCODE":"80425378","BUYERNAME":"海通证券大同向阳街证券营业部","SALESCODE":"80425378","SALESNAME":"海通证券大同向阳街证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":2.6385,"CPRICE":7.78,"YSSLTAG":1.61243398E8,"Zyl":-0.123393316195373,"Cjeltszb":0.00271827155306113,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300326","SNAME":"凯利泰","PRICE":24.5,"TVOL":23.94,"TVAL":586.53,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80035023","SALESNAME":"海通证券上海共和新路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-1.1028,"CPRICE":25.11,"YSSLTAG":7.16598673E8,"Zyl":-0.0242931103146157,"Cjeltszb":3.25962408516323E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300347","SNAME":"泰格医药","PRICE":105.55,"TVOL":1.97,"TVAL":207.93,"BUYERCODE":"80357508","BUYERNAME":"中信证券北京总部证券营业部","SALESCODE":"80398547","SALESNAME":"华创证券上海东方路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-1.9781,"CPRICE":105.55,"YSSLTAG":5.40885086E8,"Zyl":0,"Cjeltszb":3.64211713606024E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300369","SNAME":"绿盟科技","PRICE":21.69,"TVOL":100,"TVAL":2169,"BUYERCODE":"80900941","BUYERNAME":"东亚前海证券上海分公司","SALESCODE":"80033306","SALESNAME":"中信建投证券北京安立路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0,"CPRICE":22.07,"YSSLTAG":7.25976402E8,"Zyl":-0.0172179429089261,"Cjeltszb":0.00135373829560244,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300498","SNAME":"温氏股份","PRICE":23,"TVOL":130,"TVAL":2990,"BUYERCODE":"ff0befd7875c8a161b6aafff2eb3405f","BUYERNAME":"机构专用","SALESCODE":"80033398","SALESNAME":"广发证券深圳后海证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.0467,"CPRICE":23.17,"YSSLTAG":4.844515798E9,"Zyl":-0.00733707380233062,"Cjeltszb":2.66375806760651E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300498","SNAME":"温氏股份","PRICE":23.1,"TVOL":21,"TVAL":485.1,"BUYERCODE":"80166178","BUYERNAME":"广发证券佛山岭南大道北证券营业部","SALESCODE":"80141030","SALESNAME":"平安证券深圳深南东路罗湖商务中心证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.0467,"CPRICE":23.17,"YSSLTAG":4.844515798E9,"Zyl":-0.00302114803625375,"Cjeltszb":4.32170247022047E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300572","SNAME":"安车检测","PRICE":72.6,"TVOL":5.96,"TVAL":432.7,"BUYERCODE":"80166178","BUYERNAME":"广发证券佛山岭南大道北证券营业部","SALESCODE":"80141030","SALESNAME":"平安证券深圳深南东路罗湖商务中心证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-3.0717,"CPRICE":71.63,"YSSLTAG":1.39111263E8,"Zyl":0.0135418120899065,"Cjeltszb":4.34239824461943E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300594","SNAME":"朗进科技","PRICE":23.88,"TVOL":40,"TVAL":955.2,"BUYERCODE":"80097528","BUYERNAME":"招商证券济南泉城路证券营业部","SALESCODE":"80406321","SALESNAME":"招商证券福清江滨路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":3.177,"CPRICE":27.28,"YSSLTAG":6.78717E7,"Zyl":-0.124633431085044,"Cjeltszb":0.0051589488338436,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300669","SNAME":"沪宁股份","PRICE":32.3,"TVOL":180,"TVAL":5814,"BUYERCODE":"80032146","BUYERNAME":"东兴证券上海肇嘉浜路证券营业部","SALESCODE":"80129229","SALESNAME":"东兴证券福州五四路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.3517,"CPRICE":34,"YSSLTAG":5.3109319E7,"Zyl":-0.05,"Cjeltszb":0.0321977391576043,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300669","SNAME":"沪宁股份","PRICE":32.3,"TVOL":60,"TVAL":1938,"BUYERCODE":"80056623","BUYERNAME":"兴业证券福州工业路证券营业部","SALESCODE":"80129229","SALESNAME":"东兴证券福州五四路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.3517,"CPRICE":34,"YSSLTAG":5.3109319E7,"Zyl":-0.05,"Cjeltszb":0.0107325797192014,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300710","SNAME":"万隆光电","PRICE":28.62,"TVOL":25.3,"TVAL":724.09,"BUYERCODE":"80998230","BUYERNAME":"长城证券绍兴金柯桥大道营业部","SALESCODE":"80998230","SALESNAME":"长城证券绍兴金柯桥大道营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.4331,"CPRICE":27.83,"YSSLTAG":3.3524E7,"Zyl":0.0283866331297162,"Cjeltszb":0.00776110414866061,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300750","SNAME":"宁德时代","PRICE":200.68,"TVOL":1,"TVAL":200.68,"BUYERCODE":"80035327","BUYERNAME":"中信建投证券北京丹棱街证券营业部","SALESCODE":"ff0befd7875c8a161b6aafff2eb3405f","SALESNAME":"机构专用","Stype":"EQA","Unit":"万股","RCHANGE":-1.7671,"CPRICE":200.68,"YSSLTAG":1.225589086E9,"Zyl":0,"Cjeltszb":8.1593415886538E-6,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300751","SNAME":"迈为股份","PRICE":351.51,"TVOL":20,"TVAL":7030.2,"BUYERCODE":"80485021","BUYERNAME":"华林证券深圳海秀路证券营业部","SALESCODE":"80035669","SALESNAME":"东吴证券苏州石路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.4424,"CPRICE":358.68,"YSSLTAG":2.8918888E7,"Zyl":-0.0199899631983942,"Cjeltszb":0.00677764675323343,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300782","SNAME":"卓胜微","PRICE":378.1,"TVOL":1.22,"TVAL":461.28,"BUYERCODE":"80097528","BUYERNAME":"招商证券济南泉城路证券营业部","SALESCODE":"80356656","SALESNAME":"海通证券上海普陀区宜川路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.5094,"CPRICE":417.97,"YSSLTAG":1.05786176E8,"Zyl":-0.0953896212646841,"Cjeltszb":1.04325528982602E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300782","SNAME":"卓胜微","PRICE":378.1,"TVOL":1.21,"TVAL":457.5,"BUYERCODE":"80097528","BUYERNAME":"招商证券济南泉城路证券营业部","SALESCODE":"80356656","SALESNAME":"海通证券上海普陀区宜川路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.5094,"CPRICE":417.97,"YSSLTAG":1.05786176E8,"Zyl":-0.0953896212646841,"Cjeltszb":1.03470624153531E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300782","SNAME":"卓胜微","PRICE":378.1,"TVOL":1.21,"TVAL":457.5,"BUYERCODE":"80357508","BUYERNAME":"中信证券北京总部证券营业部","SALESCODE":"80356656","SALESNAME":"海通证券上海普陀区宜川路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.5094,"CPRICE":417.97,"YSSLTAG":1.05786176E8,"Zyl":-0.0953896212646841,"Cjeltszb":1.03470624153531E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"300803","SNAME":"指南针","PRICE":52.44,"TVOL":4.08,"TVAL":213.96,"BUYERCODE":"80357508","BUYERNAME":"中信证券北京总部证券营业部","SALESCODE":"80398547","SALESNAME":"华创证券上海东方路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":-0.1903,"CPRICE":52.44,"YSSLTAG":5.69E7,"Zyl":0,"Cjeltszb":7.17063538344601E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESZ"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"600131","SNAME":"国网信通","PRICE":22.8,"TVOL":230,"TVAL":5244,"BUYERCODE":"80144313","BUYERNAME":"兴业证券成都航空路证券营业部","SALESCODE":"80144313","SALESNAME":"兴业证券成都航空路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":5.1431,"CPRICE":25.35,"YSSLTAG":4.07658931E8,"Zyl":-0.100591715976331,"Cjeltszb":0.00507443574995402,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESH"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"600161","SNAME":"天坛生物","PRICE":50.01,"TVOL":10,"TVAL":500.1,"BUYERCODE":"80033289","BUYERNAME":"中信建投证券上海控江路证券营业部","SALESCODE":"80032378","SALESNAME":"招商证券哈尔滨长江路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":4.2092,"CPRICE":50.01,"YSSLTAG":1.254440168E9,"Zyl":0,"Cjeltszb":7.97168350878254E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESH"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"600161","SNAME":"天坛生物","PRICE":50.01,"TVOL":5,"TVAL":250.05,"BUYERCODE":"80035327","BUYERNAME":"中信建投证券北京丹棱街证券营业部","SALESCODE":"80032378","SALESNAME":"招商证券哈尔滨长江路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":4.2092,"CPRICE":50.01,"YSSLTAG":1.254440168E9,"Zyl":0,"Cjeltszb":3.98584175439127E-5,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESH"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"600183","SNAME":"生益科技","PRICE":27.9,"TVOL":76.3,"TVAL":2128.77,"BUYERCODE":"80664214","BUYERNAME":"中信建投证券邯郸人民东路证券营业部","SALESCODE":"80032378","SALESNAME":"招商证券哈尔滨长江路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":1.3808,"CPRICE":27.9,"YSSLTAG":2.284508266E9,"Zyl":0,"Cjeltszb":3.33988723680985E-4,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESH"},{"TDATE":"2020-08-10T00:00:00","SECUCODE":"600519","SNAME":"贵州茅台","PRICE":1467.9,"TVOL":1,"TVAL":1467.9,"BUYERCODE":"80355570","BUYERNAME":"开源证券四川分公司","SALESCODE":"80156309","SALESNAME":"华泰证券成都晋阳路证券营业部","Stype":"EQA","Unit":"万股","RCHANGE":0.1833,"CPRICE":1633.99,"YSSLTAG":1.2561978E9,"Zyl":-0.101646888903849,"Cjeltszb":7.15136669636065E-6,"RCHANGE1DC":"-","RCHANGE5DC":"-","RCHANGE10DC":"-","RCHANGE20DC":"-","TEXCH":"CNSESH"}]
     */

    private int pages;
    private List<DataBean> data;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * TDATE : 2020-08-10T00:00:00
         * SECUCODE : 000547
         * SNAME : 航天发展
         * PRICE : 20.7
         * TVOL : 15.22
         * TVAL : 315.05
         * BUYERCODE : 80166178
         * BUYERNAME : 广发证券佛山岭南大道北证券营业部
         * SALESCODE : 80141030
         * SALESNAME : 平安证券深圳深南东路罗湖商务中心证券营业部
         * Stype : EQA
         * Unit : 万股
         * RCHANGE : -3.1053
         * CPRICE : 19.97
         * YSSLTAG : 1.205405063E9
         * Zyl : 0.0365548322483726
         * Cjeltszb : 1.30878529803965E-4
         * RCHANGE1DC : -
         * RCHANGE5DC : -
         * RCHANGE10DC : -
         * RCHANGE20DC : -
         * TEXCH : CNSESZ
         */

        private String TDATE;
        private String SECUCODE;
        private String SNAME;
        private double PRICE;
        private double TVOL;
        private double TVAL;
        private String BUYERCODE;
        private String BUYERNAME;
        private String SALESCODE;
        private String SALESNAME;
        private String Stype;
        private String Unit;
        private double RCHANGE;
        private double CPRICE;
        private double YSSLTAG;
        private double Zyl;
        private double Cjeltszb;
        private String RCHANGE1DC;
        private String RCHANGE5DC;
        private String RCHANGE10DC;
        private String RCHANGE20DC;
        private String TEXCH;

        public String getTDATE() {
            return TDATE;
        }

        public void setTDATE(String TDATE) {
            this.TDATE = TDATE;
        }

        public String getSECUCODE() {
            return SECUCODE;
        }

        public void setSECUCODE(String SECUCODE) {
            this.SECUCODE = SECUCODE;
        }

        public String getSNAME() {
            return SNAME;
        }

        public void setSNAME(String SNAME) {
            this.SNAME = SNAME;
        }

        public double getPRICE() {
            return PRICE;
        }

        public void setPRICE(double PRICE) {
            this.PRICE = PRICE;
        }

        public double getTVOL() {
            return TVOL;
        }

        public void setTVOL(double TVOL) {
            this.TVOL = TVOL;
        }

        public double getTVAL() {
            return TVAL;
        }

        public void setTVAL(double TVAL) {
            this.TVAL = TVAL;
        }

        public String getBUYERCODE() {
            return BUYERCODE;
        }

        public void setBUYERCODE(String BUYERCODE) {
            this.BUYERCODE = BUYERCODE;
        }

        public String getBUYERNAME() {
            return BUYERNAME;
        }

        public void setBUYERNAME(String BUYERNAME) {
            this.BUYERNAME = BUYERNAME;
        }

        public String getSALESCODE() {
            return SALESCODE;
        }

        public void setSALESCODE(String SALESCODE) {
            this.SALESCODE = SALESCODE;
        }

        public String getSALESNAME() {
            return SALESNAME;
        }

        public void setSALESNAME(String SALESNAME) {
            this.SALESNAME = SALESNAME;
        }

        public String getStype() {
            return Stype;
        }

        public void setStype(String Stype) {
            this.Stype = Stype;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public double getRCHANGE() {
            return RCHANGE;
        }

        public void setRCHANGE(double RCHANGE) {
            this.RCHANGE = RCHANGE;
        }

        public double getCPRICE() {
            return CPRICE;
        }

        public void setCPRICE(double CPRICE) {
            this.CPRICE = CPRICE;
        }

        public double getYSSLTAG() {
            return YSSLTAG;
        }

        public void setYSSLTAG(double YSSLTAG) {
            this.YSSLTAG = YSSLTAG;
        }

        public double getZyl() {
            return Zyl;
        }

        public void setZyl(double Zyl) {
            this.Zyl = Zyl;
        }

        public double getCjeltszb() {
            return Cjeltszb;
        }

        public void setCjeltszb(double Cjeltszb) {
            this.Cjeltszb = Cjeltszb;
        }

        public String getRCHANGE1DC() {
            return RCHANGE1DC;
        }

        public void setRCHANGE1DC(String RCHANGE1DC) {
            this.RCHANGE1DC = RCHANGE1DC;
        }

        public String getRCHANGE5DC() {
            return RCHANGE5DC;
        }

        public void setRCHANGE5DC(String RCHANGE5DC) {
            this.RCHANGE5DC = RCHANGE5DC;
        }

        public String getRCHANGE10DC() {
            return RCHANGE10DC;
        }

        public void setRCHANGE10DC(String RCHANGE10DC) {
            this.RCHANGE10DC = RCHANGE10DC;
        }

        public String getRCHANGE20DC() {
            return RCHANGE20DC;
        }

        public void setRCHANGE20DC(String RCHANGE20DC) {
            this.RCHANGE20DC = RCHANGE20DC;
        }

        public String getTEXCH() {
            return TEXCH;
        }

        public void setTEXCH(String TEXCH) {
            this.TEXCH = TEXCH;
        }
    }
}
