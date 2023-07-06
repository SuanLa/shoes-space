package com.shoes.demo.controller;

import com.shoes.common.ResultVO;
import com.shoes.demo.api.TestApis;
import com.shoes.demo.domin.query.TestQuery;
import com.shoes.demo.domin.vo.TestVO;
import com.shoes.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tomcat
 * @Date: 2023/7/5
 **/
@RestController
@RequestMapping("/test")
@Api(tags = "test")
@Tag(name = "test",description = "测试")
@Validated
public class TestController implements TestApis {
    @Autowired
    private TestService testService;

    @GetMapping("/one/{query}")
    @ApiOperation("第一个接口")
    @ResponseBody
    @Override
    public ResultVO<TestVO> test(@PathVariable("query") TestQuery query){
        return ResultVO.success(testService.serv(query));
    }
}
