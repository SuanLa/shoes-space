package com.shoes.cart.config;

import com.shoes.common.config.SwaggerConfig;
import com.shoes.common.domin.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Tomcat
 * @Date: 2023/7/5
 **/
@Configuration
@EnableSwagger2
public class SwaggerInit extends SwaggerConfig{

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shoes.cart.controller")
                .title("shoes-space系统")
                .description("购物车模块")
                .contactName("Tomcat")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}
