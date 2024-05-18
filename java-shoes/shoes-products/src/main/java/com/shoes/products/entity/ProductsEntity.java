package com.shoes.products.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName("product")
public class ProductsEntity implements Serializable {
    private String productId;//商品ID，使用雪花算法实现

    private String productName;//商品名称

    private String productDescription;//商品描述，包含品牌、男鞋女鞋、类型、尺码、颜色;

    private String productPrice;//商品价格

    private int productNumber;//商品的库存

    private String productImg;

    private int productDelete;//逻辑删除，默认为0，删除为1

}
