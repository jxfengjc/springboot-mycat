package com.example.mongodb.controller;


import com.example.mongodb.dao.MongoTestDao;
import com.example.mongodb.entity.MongoTest;
import com.example.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestMondoDB
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@RestController
@RequestMapping("/mongo")
public class TestMongoDbController {

   /* @Autowired
    private StudentService studentService;*/
    @Autowired
    private MongoTestDao mongoTestDao;
    @GetMapping(value = "/save")
    public String saveTest() throws Exception {
        List<MongoTest> list =new ArrayList<>();
        MongoTest mgtest = new MongoTest();
        mgtest.setId(4);
        mgtest.setNumber(2020004);
        mgtest.setAge(18);
        mgtest.setName("刘能");
        mgtest.setCreateTime(new Date());
        mgtest.setSex("1");
        mgtest.setClasss(1);
        mgtest.setTuition(new BigDecimal("5000.15"));
        mgtest.setHobby("篮球,乒乓球,羽毛球");
        mgtest.setHobbyCode("0,3,4");
        mgtest.setIntroduce("我性格开朗，健谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest);
        MongoTest mgtest1 = new MongoTest();
        mgtest1.setId(5);
        mgtest1.setNumber(2020005);
        mgtest1.setAge(18);
        mgtest1.setName("张三丰");
        mgtest1.setCreateTime(new Date());
        mgtest1.setSex("2");
        mgtest1.setClasss(1);
        mgtest1.setTuition(new BigDecimal("5000.15"));
        mgtest1.setHobby("篮球,足球,乒乓球，羽毛球");
        mgtest1.setHobbyCode("0,1,3,4");
        mgtest1.setIntroduce("我性格开朗，健zz谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest1);
        MongoTest mgtest2 = new MongoTest();
        mgtest2.setId(6);
        mgtest2.setNumber(2020006);
        mgtest2.setAge(19);
        mgtest2.setName("许世荣");
        mgtest2.setCreateTime(new Date());
        mgtest2.setSex("2");
        mgtest2.setClasss(2);
        mgtest2.setTuition(new BigDecimal("5000.19"));
        mgtest2.setHobby("足球");
        mgtest2.setHobbyCode("1");
        mgtest2.setIntroduce("我性格zzzz开朗，健谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest2);
        mongoTestDao.saveTest(list);
        System.out.println("success");
        return "add successful !";
    }

    @GetMapping(value = "/find/{name}")
    public MongoTest findTestByName(@PathVariable("name")String name) {
        MongoTest mgtest = mongoTestDao.findTestByName(name);
        System.out.println("mgtest is " + mgtest);
        return mgtest;
    }
    @GetMapping(value = "/findId/{id}")
    public MongoTest findTestById(@PathVariable("id")Integer id) {
        MongoTest mgtest = mongoTestDao.findById(id);
        System.out.println("mgtest is " + mgtest);
        return mgtest;
    }

    @GetMapping(value = "/update/{id}")
    public String updateTest(@PathVariable("id")Integer id) {
        MongoTest mgtest = new MongoTest();
        mgtest.setId(id);
        mgtest.setAge(445566);
        mgtest.setName("修改人"+id);
        mongoTestDao.updateTest(mgtest);
        System.out.println("successful !");
        return "update successful !";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTestById(@PathVariable("id")Integer id) {
        mongoTestDao.deleteTestById(id);
        return "delete successful !";

    }
   /* @GetMapping(value = "/down/{id}")
    public void downLoadStudent(@PathVariable("id")Integer id, HttpServletResponse response){
        studentService.down(id,response);
    }


    @GetMapping(value = "/getMap")
    public String getMap(Integer id){
        Map<Integer, MongoTest> integerMongoTestMap = studentService.fingMap();
        System.out.println(integerMongoTestMap.get(id).getName());
        return integerMongoTestMap.get(id).toString();
    }*/
    @GetMapping(value = "/getLike")
    public String getByLike(String name){
      return mongoTestDao.getByLikeName(name).toString();
    }
    @GetMapping(value = "/getname")
    public String getByName(String name){
        return mongoTestDao.getByIsName(name).toString();
    }
    @GetMapping(value = "/getBetween")
    public String getBetween(Integer startAge,Integer endAge){
        return mongoTestDao.getBetween(startAge,endAge).toString();
    }

    @GetMapping(value = "/getCount")
    public long getCount(){
        return mongoTestDao.getCount();
    }
    @GetMapping(value = "/getIn")
    public String getIn(){
        return mongoTestDao.getIn().toString();
    }
    @GetMapping(value = "/updateOne")
    public String updateOne(Integer id,String name){
        mongoTestDao.updateOne(id,name);
        return "update success";
    }
    @GetMapping(value = "/getPage")
    public String  getAppPortDetailByPage(int pageNo, int pageSize, String order, String sortBy, String name, String hobby){
        Map<String, Object> appPortDetailByPage = mongoTestDao.getAppPortDetailByPage(pageNo, pageSize, order, sortBy, name, hobby);
        return appPortDetailByPage.toString();
    }
}
