package com.shoes.demo.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
@AllArgsConstructor
@Data
@ApiModel("测试传递")
public class TestDTO {

    @ApiModelProperty("测试消息")
    private String msg;
}
