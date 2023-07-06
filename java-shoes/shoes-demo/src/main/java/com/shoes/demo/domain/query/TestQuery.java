package com.shoes.demo.domain.query;

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
@ApiModel("测试查询")
public class TestQuery {

    @ApiModelProperty("查询消息")
    private String msg;
}
