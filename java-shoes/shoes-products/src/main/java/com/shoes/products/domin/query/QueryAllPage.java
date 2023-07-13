package com.shoes.products.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName QueryAllPage
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/7 15:01
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("测试查询")
public class QueryAllPage {
    @ApiModelProperty(value = "表示当前页码,从1开始", required = true)
    private int pageNo;
    @ApiModelProperty(value = "表示每页显示的记录数", required = true)
    private int pageSize;
    @ApiModelProperty(value = "价格的排序规则,(asc,desc)", required = true)
    private String order;
}
