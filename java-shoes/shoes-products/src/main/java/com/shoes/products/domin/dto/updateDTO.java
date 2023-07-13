package com.shoes.products.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName updateDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/8 1:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("通过id修改商品信息")
public class updateDTO {
    @ApiModelProperty(value = "商品ID",required = true)
    private String productId;//商品ID
    @ApiModelProperty("商品名称")
    private String productName;//商品名称
    @ApiModelProperty("商品描述")
    private String productDescription;//商品描述，包含品牌、男鞋女鞋、类型、尺码、颜色;
    @ApiModelProperty("商品价格")
    private String productPrice;//商品价格
    @ApiModelProperty("商品的库存")
    private int productNumber;//商品的库存
    @ApiModelProperty("商品图片路径")
    private String productImg;
}
