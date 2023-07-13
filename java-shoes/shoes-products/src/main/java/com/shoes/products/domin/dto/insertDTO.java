package com.shoes.products.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName insertDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/7 11:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("添加一个商品信息")
public class insertDTO {
    @ApiModelProperty(value = "商品名称", required = true)
    private String productName;//商品名称
    @ApiModelProperty(value = "商品描述", required = true)
    private String productDescription;//商品描述，包含品牌、男鞋女鞋、类型、尺码、颜色;
    @ApiModelProperty(value = "商品价格", required = true)
    private String productPrice;//商品价格
    @ApiModelProperty(value = "商品的库存", required = true)
    private int productNumber;//商品的库存
    @ApiModelProperty(value = "商品图片路径", required = true)
    private String productImg;
}
