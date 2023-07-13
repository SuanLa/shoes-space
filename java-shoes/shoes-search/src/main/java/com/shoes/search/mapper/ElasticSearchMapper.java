package com.shoes.search.mapper;

import com.shoes.search.entity.ElasticSearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
@Repository
public interface ElasticSearchMapper extends ElasticsearchRepository<ElasticSearchEntity,String> {
}
