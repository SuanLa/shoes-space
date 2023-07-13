package com.shoes.login.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Tomcat
 * @Date: 2023/7/13
 **/
@ApiModel("用户登出上传数据对象")
@AllArgsConstructor
@Data
public class LogOutQuery {
    @NotBlank
    @ApiModelProperty(value = "用户名",example = "admin",required = true)
    private String username;
}
