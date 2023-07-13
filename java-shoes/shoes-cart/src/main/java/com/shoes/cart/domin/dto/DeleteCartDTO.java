package com.shoes.cart.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName deleteCartItemDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/9 10:13
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("删除购物车明细")
public class DeleteCartDTO {
    @ApiModelProperty(value = "商品明细id",required = true)
    private String cartId;
}
