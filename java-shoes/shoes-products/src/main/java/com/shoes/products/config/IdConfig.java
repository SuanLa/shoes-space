package com.shoes.products.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Tomcat
 * @Date: 2024/5/7
 **/
@Component
public class IdConfig {
    @Bean
    public Snowflake getSnowflake(){
        return IdUtil.getSnowflake(1, 1);
    }
}
