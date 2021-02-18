/*
package com.example.dataconfig;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

*/
/**
 * @ClassName TestMybatisPageController
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/18
 * @Version V1.0
 **//*

@RestController
@RequestMapping("mybatis")
public class TestMybatisPageController {
    @Autowired
    private TjAdminMapper tjAdminMapper;
    public String testPage(){
        PageInfo<TjAdmin> pageInfo = PageHelper.startPage(1,2).doSelectPageInfo(()->tjAdminMapper.selectList());
        Integer count =pageInfo.getPages();
        List<TjAdmin> list =pageInfo.getList();
        return "";
    }
}
*/
