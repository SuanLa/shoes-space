package com.shoes.products.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("product")
public class product implements Serializable {
    @TableId(value = "product_id", type = IdType.NONE)
    private String productId;//商品ID，使用雪花算法实现
    @TableField("product_name")
    private String productName;//商品名称
    @TableField("product_description")
    private String productDescription;//商品描述，包含品牌、男鞋女鞋、类型、尺码、颜色;
    @TableField("product_price")
    private String productPrice;//商品价格
    @TableField("product_number")
    private int productNumber;//商品的库存
    @TableField("product_img")
    private String productImg;
    @TableLogic(value = "0", delval = "1")
    private int productDelete;//逻辑删除，默认为0，删除为1

}
