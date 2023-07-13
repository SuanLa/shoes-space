package com.shoes.search.domin.vo;

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
public class ElasticSearchVO {
    @ApiModelProperty("产品id")
    private String productId;

    @ApiModelProperty("产品名")
    private String productName;

    @ApiModelProperty("产品描述")
    private String productDescription;

    @ApiModelProperty("产品价格")
    private String productPrice;

    @ApiModelProperty("产品数量")
    private int productNumber;

    @ApiModelProperty("产品图片路径")
    private String productImg;

    @ApiModelProperty("产品删除")
    private int productDelete;
}
