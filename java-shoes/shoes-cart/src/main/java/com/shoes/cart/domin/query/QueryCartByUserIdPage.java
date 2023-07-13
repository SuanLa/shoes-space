package com.shoes.cart.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName QueryCartByUserIdPage
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/9 10:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("通过用户id查询商品明细")
public class QueryCartByUserIdPage implements Serializable {
    @ApiModelProperty(value = "用户id",required = true)
    private String userId;
    @ApiModelProperty(value = "表示当前页码,从1开始",required = true)
    private int pageNo;
    @ApiModelProperty(value = "表示每页显示的记录数",required = true)
    private int pageSize;
}
