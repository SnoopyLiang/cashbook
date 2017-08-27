package com.github.snoopyliang.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by yuyokun on 2017/8/27.
 */
@Configuration
@MapperScan("com.github.snoopyliang.dao.mapper*")
public class MybatisPlusConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setGlobalConfig(globalConfiguration());
        sessionFactoryBean.setTypeAliasesPackage("com.github.snoopyliang.dao.entity");
        Interceptor[] interceptors = new Interceptor[1];
        interceptors[0] = paginationInterceptor();
        sessionFactoryBean.setPlugins(interceptors);
        return sessionFactoryBean;
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration config = new GlobalConfiguration();
        config.setDbColumnUnderline(true);
        config.setIdType(2);
        return config;
    }


}
