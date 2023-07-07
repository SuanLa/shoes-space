package com.shoes.login.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.shoes.common.config.SwaggerConfig;
import com.shoes.common.domin.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

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
                .apiBasePackage("com.shoes.login.controller")
                .title("shoes-space系统")
                .description("登录模块")
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
