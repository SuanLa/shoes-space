package com.shoes.search.service;

import com.shoes.common.PageVO;
import com.shoes.common.ResultVO;
import com.shoes.search.domin.dto.ElasticSearchDTO;
import com.shoes.search.domin.query.ElasticSearchPageQuery;
import com.shoes.search.domin.query.ElasticSearchQuery;
import com.shoes.search.domin.vo.ElasticSearchVO;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
public interface ElasticSearchService {
    /**
     * @param dto
     * @return
     */
    ElasticSearchVO insert(ElasticSearchDTO dto);

    /**
     * @param query 查询实体
     * @return 操作返回值
     */
    Optional<ElasticSearchVO> queryByName(ElasticSearchQuery query);

    /**
     * @param pageQuery 分页查询实体
     * @return 返回分页数据
     */
    PageVO<Page<ElasticSearchVO>>  queryPage(ElasticSearchPageQuery pageQuery);

    /**
     * @param dto 修改实体
     * @return 返回修改数据
     */
    ElasticSearchVO update(ElasticSearchDTO dto);

    /**
     * @param dto 删除实体
     * @return 返回删除结果
     */
    String delete(ElasticSearchDTO dto);
}
