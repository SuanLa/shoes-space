package com.shoes.gateway.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * @Author: Tomcat
 * @Date: 2023/7/13
 **/
@Component
public class PredicatePath {
    @Bean
    public AntPathMatcher wierd(){
        return new AntPathMatcher();
    }
}
