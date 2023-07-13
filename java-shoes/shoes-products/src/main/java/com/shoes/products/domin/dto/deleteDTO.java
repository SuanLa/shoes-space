package com.shoes.products.domin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName deleteDTO
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/7 20:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("通过id删除一个商品信息")
public class deleteDTO {
    @ApiModelProperty(value = "商品ID",required = true)
    private String productId;//商品ID
}
