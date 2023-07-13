package com.shoes.products.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("测试查询")
public class QueryById implements Serializable {
    @ApiModelProperty(value = "商品ID", required = true)
    private String productId;//商品ID
}
