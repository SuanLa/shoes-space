package com.shoes.demo.domin.vo;

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
@ApiModel("测试返回")
public class TestVO {

    @ApiModelProperty("返回消息")
    private String msg;
}
