package com.shoes.demo.config;

import com.shoes.common.config.SwaggerConfig;
import com.shoes.common.domin.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.oas.annotations.EnableOpenApi;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

/**
 * @Author: Tomcat
 * @Date: 2023/7/5
 **/
@Configuration
@EnableOpenApi
@EnableSwaggerBootstrapUI
public class SwaggerInit extends SwaggerConfig{

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shoes.demo.controller")
                .title("shoes-space系统")
                .description("测试模块")
                .contactName("Tomcat")
                .version("0.0.1-SNAPSHOT")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}
