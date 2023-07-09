package com.shoes.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
@Data
@AllArgsConstructor
public class LoginEntity {
    private String username;

    private String passwd;
}
