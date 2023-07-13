package com.shoes.cart.domin.vo;

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
@ApiModel("返回用户的购物车明细")
public class cartVO implements Serializable {
    @ApiModelProperty("商品明细ID")
    private String cartId;
    @ApiModelProperty("购物车id")
    private String userId;
    @ApiModelProperty("商品ID")
    private String productId;
    @ApiModelProperty("商品名称")
    private String productName;//商品名称
    @ApiModelProperty("商品价格")
    private String productPrice;//商品价格
    @ApiModelProperty("商品的数量")
    private int productNumber;//商品的数量
}
