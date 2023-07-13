package com.shoes.cart.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName cartItem
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/8 23:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("cart")
public class cart implements Serializable {
    @TableId(value = "cart_id",type = IdType.NONE)
    private String cartId;
    @TableField("user_id")
    private String userId;
    @TableField("product_id")
    private String productId;
    @TableField("product_name")
    private String productName;
    @TableField("product_price")
    private String productPrice;
    @TableField("product_number")
    private int productNumber;
    @TableField("cart_delete")
    @TableLogic(value = "0",delval = "1")
    private String cartDelete;

}
