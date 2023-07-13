package com.shoes.cart.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName QueryCartByCartId
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/9 23:31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("通过cartid查询商品明细")
public class QueryCartByCartId implements Serializable {
    @ApiModelProperty(value = "cartId",required = true)
    private String cartId;
}
