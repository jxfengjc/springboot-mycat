package com.example.dataconfig;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName Config
 * @Description: 单数据源配置
 * @Author fengjc
 * @Date 2021/1/26
 * @Version V1.0
 **/
@Configuration
@MapperScan(basePackages = "com.zfxf.toujiao.dao.mapper", sqlSessionTemplateRef  = "toujiaoSqlSessionTemplate")
public class Config {

    @Bean(name = "toujiaoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.toujiao")
    public DataSource toujiaoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "toujiaoSqlSessionFactory")
    public SqlSessionFactory toujiaoSqlSessionFactory(@Qualifier("toujiaoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/zfxf/toujiao/dao/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "toujiaoTransactionManager")
    public DataSourceTransactionManager toujiaoTransactionManager(@Qualifier("toujiaoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "toujiaoSqlSessionTemplate")
    public SqlSessionTemplate toujiaoSqlSessionTemplate(@Qualifier("toujiaoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
