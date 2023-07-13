package com.shoes.search.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/12
 **/
@Data
@ApiModel("产品查询实体")
@AllArgsConstructor
public class ElasticSearchQuery {
    @ApiModelProperty("产品名")
    private String productName;
}
