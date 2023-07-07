package com.shoes.login.domin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
@ApiModel("用户登录返回对象")
@AllArgsConstructor
@Data
public class LoginVO {
    @ApiModelProperty(value = "用户名",example = "admin",required = true)
    private String username;

    @ApiModelProperty(value = "是否在线",example = "true",required = true)
    private boolean online;
}
