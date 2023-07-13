package com.shoes.gateway.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Tomcat
 * @Date: 2023/7/13
 **/
@Configuration
@ComponentScan("com.shoes.common.config.redis")
public class RedisInit {
}
