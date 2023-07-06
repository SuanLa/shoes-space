package com.shoes.demo.api;

import com.shoes.common.ResultVO;
import com.shoes.demo.domain.query.TestQuery;
import com.shoes.demo.domain.vo.TestVO;

/**
 * 测试接口
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
public interface TestApis {
    ResultVO<TestVO> test(TestQuery query);
}
