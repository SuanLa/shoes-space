package com.shoes.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
@Data
@Document(indexName = "es_product")
public class ElasticSearchEntity {
    @Id
    private String productName;

    private String productId;

    private String productDescription;
}
