package com.shoes.search.service.impl;

import cn.hutool.core.convert.Convert;
import com.shoes.common.PageVO;
import com.shoes.search.domin.dto.ElasticSearchDTO;
import com.shoes.search.domin.query.ElasticSearchPageQuery;
import com.shoes.search.domin.query.ElasticSearchQuery;
import com.shoes.search.domin.vo.ElasticSearchVO;
import com.shoes.search.entity.ElasticSearchEntity;
import com.shoes.search.mapper.ElasticSearchMapper;
import com.shoes.search.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Autowired
    private ElasticSearchMapper mapper;

    @Override
    public ElasticSearchVO insert(ElasticSearchDTO dto) {
        ElasticSearchEntity save = mapper.save(Convert.convert(ElasticSearchEntity.class, dto));
        return Convert.convert(ElasticSearchVO.class, save);
    }

    @Override
    public Optional<ElasticSearchVO> queryByName(ElasticSearchQuery query) {
        Optional<ElasticSearchEntity> byId = mapper.findById(query.getProductName());
        Optional<ElasticSearchVO> result = Convert.convert(Optional.class,byId);
        return result;
    }

    @Override
    public PageVO<Page<ElasticSearchVO>> queryPage(ElasticSearchPageQuery pageQuery) {
        Page<ElasticSearchEntity> page = mapper.findAll(Pageable.ofSize(pageQuery.getPageNumber()));
        return PageVO.restPage(Convert.convert(Page.class,page));
    }

    @Override
    public ElasticSearchVO update(ElasticSearchDTO dto) {
        ElasticSearchEntity update = mapper.save(Convert.convert(ElasticSearchEntity.class, dto));
        return Convert.convert(ElasticSearchVO.class,update);
    }

    @Override
    public String delete(ElasticSearchDTO dto) {
        mapper.deleteById(dto.getProductName());
        return "删除成功";
    }
}
