package com.example.mongodb.dao;

import com.example.mongodb.entity.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MongoTestDao
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/25
 * @Version V1.0
 **/
@Repository
public class MongoTestDao {
    private static final String COLLECTIONNAME_STUDENT = "student" ;
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param list
     */
    public void saveTest(List<MongoTest> list){
        //insert 和save的区别
        //insert 若新增的主键已经存在则会抛出异常，save会修改当前存在的数据
        //insert 可以一次性插入整个列表，而不用遍历操作，效率高，save则时循环插入
        //  mongoTemplate.save(mongoTest,"student");
        mongoTemplate.insert(list,"student");
    }
    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    public MongoTest findTestByName(String name){

        Query query =new Query(Criteria.where("name").is(name));
        MongoTest mongoTest =   mongoTemplate.findOne(query,MongoTest.class,"student");
        return mongoTest;
    }
    /**
     * 根据用户名查询对象
     * @param id
     * @return
     */
    public MongoTest findById(Integer id){

        Query query =new Query(Criteria.where("id").is(id));
        MongoTest mongoTest =   mongoTemplate.findOne(query,MongoTest.class,"student");
        return mongoTest;
    }
    /**
     * 根据用户id查询对象
     * @param id
     * @return
     */
    public List<MongoTest> findTestById(Integer id){

        Query query =new Query();
        Criteria criteria =new Criteria();
        if(id !=null){
            criteria.and("id").is(id);
        }
        query.addCriteria(criteria);
        List<MongoTest> mongoTest =   mongoTemplate.find(query,MongoTest.class,"student");
        return mongoTest;
    }

    /**
     * 更改对象
     * @param test
     */
    public void updateTest(MongoTest test){
        Query query =new Query(Criteria.where("id").is(test.getId()));
        Update update =new Update().set("name",test.getName()).set("age",test.getAge());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,MongoTest.class,"student");
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }
    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoTest.class,"student");
    }
    /**
     * 根据姓名精确查询
     * @param name
     * @return
     */
    public MongoTest getByIsName(String name) {
      return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 根据姓名模糊查询
     * @return
     */
    public List<MongoTest> getByLikeName(String name){
        return mongoTemplate.find(new Query(Criteria.where("name").regex(name)),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 范围查询
     * gte 大于等于 ,lte 小于等于 ,gt 大于 ,lt 小于
     * @param startAge
     * @param endAge
     * @return
     */
    public List<MongoTest> getBetween(Integer startAge,Integer endAge){
        Criteria criteria =new Criteria();
        criteria.andOperator(
          Criteria.where("age").gte(startAge),Criteria.where("age").lte(endAge)
        );
        return mongoTemplate.find(new Query(criteria),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 查询字段不存在的数据  关键字not
     * @param hobby
     * @return
     */
    public List<MongoTest> getNot(String hobby){
        return mongoTemplate.find(new Query( Criteria.where("hobby").not()),
                MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 查询字段不为空
     * @param hobby
     * @return
     */
    public List<MongoTest> getNotNull(String hobby){
        return mongoTemplate.find(new Query(Criteria.where("hobby").ne("").ne(null)),
                MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 查询字段 or
     * @param text
     * @return
     */
    public List<MongoTest> getOr(String text){
        Criteria criteria =new Criteria();
        criteria.orOperator(
                Criteria.where("id").is(text),Criteria.where("name").is(text)
        );
        return mongoTemplate.find(new Query(criteria),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 查询 并且
     * @param age
     * @param name
     * @return
     */
    public List<MongoTest> getAnd(Integer age,String name){
        Criteria criteria =new Criteria();
        criteria.and("age").is(age);
        criteria.and("name").is(name);
        return mongoTemplate.find(new Query(criteria),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 获取数量
     * @return
     */
    public long getCount(){
        return mongoTemplate.count(new Query(),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 查找包含在某个集合范围：----- 关键字---in
     * 排序 sort
     * @return
     */
    public List<MongoTest> getIn(){
        Criteria criteria =new Criteria();
        Integer [] o ={2020001,2020002};
        criteria.and("number").in(o);
        Query query =new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("id")));
        return mongoTemplate.find(query,MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 更改数据
     * @param id
     * @param name
     */
    public void updateOne(Integer id , String name){
        Update update =new Update();
        update.set("name",name);
       mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)),
                update,COLLECTIONNAME_STUDENT);
    }

    public void delete(Integer id){
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),MongoTest.class,COLLECTIONNAME_STUDENT);
    }

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @param order
     * @param sortBy
     * @param name
     * @param hobby
     * @return
     */
    public Map<String, Object> getAppPortDetailByPage(int pageNo, int pageSize, String order, String sortBy, String name, String hobby) {
        Criteria criteria = new Criteria();
        if (!name.equals("")) {
            if (!name.equals("all")) {
                criteria.and("name").is(name);
            }
        }
        if (!hobby.equals("")) {
            try {
                criteria.orOperator(Criteria.where("hobby").is(Integer.parseInt(hobby)),
                        Criteria.where("hobby").regex(".*?" + hobby + ".*"));
            } catch (Exception e) {
                criteria.orOperator(Criteria.where("hobby").regex(".*?" + hobby + ".*"));
            }
        }
        Map<String, Object> result = new HashMap<>();
        Query query = new Query(criteria);
        query.skip((pageNo - 1) * pageSize);
        query.limit(pageSize);
        if (order != null && sortBy != null) {
            query.with(Sort.by(order.equals("asc")?Sort.Order.asc(sortBy):Sort.Order.desc(sortBy)));
        } else {
            query.with(Sort.by(Sort.Order.asc("port")));
        }
        List<MongoTest> list = this.mongoTemplate.find(query, MongoTest.class,COLLECTIONNAME_STUDENT);
        long count = this.mongoTemplate.count(query, MongoTest.class);
        result.put("datas", list);
        result.put("size", count);
        return result;
    }

}
