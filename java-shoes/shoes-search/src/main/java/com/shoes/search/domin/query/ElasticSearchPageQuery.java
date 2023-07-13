package com.shoes.search.domin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2023/7/12
 **/
@Data
@ApiModel("产品分页查询实体")
@AllArgsConstructor
public class ElasticSearchPageQuery {
    @ApiModelProperty("产品名")
    private String productName;

    @ApiModelProperty("分页数量")
    private int pageNumber;

    @ApiModelProperty("分页位置")
    private int pageIndex;
}
