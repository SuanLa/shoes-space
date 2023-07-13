package com.shoes.search.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/12
 **/
@Data
@ApiModel("es实体")
@AllArgsConstructor
public class ElasticSearchDTO {
    @ApiModelProperty("产品id")
    private String productId;

    @ApiModelProperty("产品名")
    private String productName;

    @ApiModelProperty("产品描述")
    private String productDescription;
}
