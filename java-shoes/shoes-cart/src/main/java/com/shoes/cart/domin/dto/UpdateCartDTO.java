package com.shoes.cart.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName updateCartItemDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/9 10:09
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("修改购物车明细")
public class UpdateCartDTO {
    @ApiModelProperty(value = "商品明细ID",required = true)
    private String cartId;
    @ApiModelProperty(value = "商品的数量",required = true)
    private int productNumber;//商品的数量
}
