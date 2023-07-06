package com.shoes.demo.api;

import com.shoes.common.ResultVO;
import com.shoes.demo.domin.query.TestQuery;
import com.shoes.demo.domin.vo.TestVO;

/**
 * 测试接口
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
public interface TestApis {
    ResultVO<TestVO> test(TestQuery query);
}
