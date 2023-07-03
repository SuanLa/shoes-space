package com.shoes.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Tomcat
 * @Date: 2023/7/2
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class,args);
    }
}
