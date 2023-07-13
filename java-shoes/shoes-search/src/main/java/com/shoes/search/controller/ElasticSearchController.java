package com.shoes.search.controller;

import cn.hutool.core.convert.Convert;
import com.shoes.common.PageVO;
import com.shoes.common.ResultVO;
import com.shoes.search.api.ElasticSearchApis;
import com.shoes.search.domin.dto.ElasticSearchDTO;
import com.shoes.search.domin.query.ElasticSearchPageQuery;
import com.shoes.search.domin.query.ElasticSearchQuery;
import com.shoes.search.domin.vo.ElasticSearchVO;
import com.shoes.search.entity.ElasticSearchEntity;
import com.shoes.search.mapper.ElasticSearchMapper;
import com.shoes.search.service.ElasticSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Author: Tomcat
 * @Date: 2023/7/10
 **/
@RestController
@RequestMapping("/es")
@Api(tags = "es")
@Tag(name = "es",description = "搜索")
@Validated
public class ElasticSearchController implements ElasticSearchApis {
    @Autowired
    private ElasticSearchService service;

    @PostMapping("/insert")
    @ApiOperation("插入接口")
    @Override
    public ResultVO<ElasticSearchVO> insert(ElasticSearchDTO dto) {
        return ResultVO.success(service.insert(dto));
    }

    @GetMapping("/query")
    @ApiOperation("查询接口")
    @Override
    public ResultVO<Optional<ElasticSearchVO>> query(ElasticSearchQuery query) {
        return ResultVO.success(service.queryByName(query));
    }

    @GetMapping("/queryByPage")
    @ApiOperation("分页查询接口")
    @Override
    public ResultVO<PageVO<Page<ElasticSearchVO>>> queryByPage(ElasticSearchPageQuery pageQuery) {
        return ResultVO.success(service.queryPage(pageQuery));
    }

    @PutMapping("/update")
    @ApiOperation("更新接口")
    @Override
    public ResultVO<ElasticSearchVO> update(ElasticSearchDTO dto) {
        return ResultVO.success(service.update(dto));
    }

    @DeleteMapping ("/delete")
    @ApiOperation("删除接口")
    @Override
    public ResultVO<String> delete(ElasticSearchDTO dto) {
        return ResultVO.success("删除成功");
    }
}
