package com.shoes.search.api;

import com.shoes.common.PageVO;
import com.shoes.common.ResultVO;
import com.shoes.search.domin.dto.ElasticSearchDTO;
import com.shoes.search.domin.query.ElasticSearchPageQuery;
import com.shoes.search.domin.query.ElasticSearchQuery;
import com.shoes.search.domin.vo.ElasticSearchVO;
import com.shoes.search.entity.ElasticSearchEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
public interface ElasticSearchApis {
    /**
     * @param dto 插入实体
     * @return 返回插入结果
     */
    ResultVO<ElasticSearchVO> insert(ElasticSearchDTO dto);

    /**
     * @param query 查询实体
     * @return 返回查询结果
     */
    ResultVO<Optional<ElasticSearchVO>> query(ElasticSearchQuery query);

    /**
     * @param pageQuery 分页查询实体
     * @return 返回分页查询数据
     */
    ResultVO<PageVO<Page<ElasticSearchVO>> > queryByPage(ElasticSearchPageQuery pageQuery);

    /**
     * @param dto 更新实体
     * @return 返回更新实体
     */
    ResultVO<ElasticSearchVO> update(ElasticSearchDTO dto);

    /**
     * @param dto 删除实体
     * @return 返回删除结果
     */
    ResultVO<String> delete(ElasticSearchDTO dto);
}
