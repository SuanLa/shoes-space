package com.shoes.login.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
@ApiModel("用户登录上传数据对象")
@AllArgsConstructor
@Data
public class LoginDTO {
    @NotBlank
    @ApiModelProperty(value = "用户名",example = "admin",required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "用户密码",example = "123456",required = true)
    private String password;
}
