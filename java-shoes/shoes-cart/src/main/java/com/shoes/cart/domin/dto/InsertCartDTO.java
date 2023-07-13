package com.shoes.cart.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName insertCartItemDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/9 10:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("插入购物车明细")
public class InsertCartDTO {
    @ApiModelProperty(value = "购物车id",required = true)
    private String cartId;
    @ApiModelProperty(value = "用户id",required = true)
    private String userId;
    @ApiModelProperty(value = "商品ID",required = true)
    private String productId;
    @ApiModelProperty(value = "商品名称",required = true)
    private String productName;//商品名称
    @ApiModelProperty(value = "商品单价",required = true)
    private String productPrice;//商品价格
    @ApiModelProperty(value = "商品的数量",required = true)
    private int productNumber;//商品的数量
}
