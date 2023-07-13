package com.shoes.login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tomcat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEntity {
    /**
     * 主题
     */
    private String sub;

    /**
     * 签发时间
     */
    private Long iat;

    /**
     * 过期时间
     */
    private Long exp;

    /**
     * JWT的ID
     */
    private String jti;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户拥有的权限
     */
//    private List<String> authorities;
}
