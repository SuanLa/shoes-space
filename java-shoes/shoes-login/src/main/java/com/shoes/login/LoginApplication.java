package com.shoes.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Tomcat
 * @Date: 2023/7/2
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.shoes.login.mapper")
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class,args);
    }
}
