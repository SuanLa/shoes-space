package com.shoes.gateway.filter;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;

/**
 * @Author: Tomcat
 * @Date: 2023/7/13
 **/
@Component
public class TokenFilter implements GlobalFilter, Ordered {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        URI uri = request.getURI();

        if ("/admin/**".equals(uri.getPath())){
            return chain.filter(exchange);
        }

        if ("/products/**".equals(uri.getPath())){
            return chain.filter(exchange);
        }

        String token = request.getHeaders().get("token").get(0);
        String user = request.getHeaders().get("user").get(0);
        String tok = redisTemplate.opsForValue().get(user);
        if (tok.equals(token)){
            return chain.filter(exchange);
        }

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
