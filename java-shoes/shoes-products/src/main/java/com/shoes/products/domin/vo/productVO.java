package com.shoes.products.domin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("商品")
public class productVO implements Serializable {
    @ApiModelProperty("商品ID")
    private String productId;//商品ID，使用雪花算法实现
    @ApiModelProperty("商品名称")
    private String productName;//商品名称
    @ApiModelProperty("商品描述")
    private String productDescription;//商品描述，包含品牌、男鞋女鞋、类型、尺码、颜色;
    @ApiModelProperty("商品价格")
    private String productPrice;//商品价格
    @ApiModelProperty("商品的库存")
    private int productNumber;//商品的库存
    @ApiModelProperty("商品图片路径")
    private String productImg;
}
