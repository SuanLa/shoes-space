package com.shoes.common.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: Tomcat
 * @Date: 2023/7/5
 **/
@Configuration
public class MybatisConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect","Mysql");
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("rowBoundsWithCount","true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
