package com.shoes.demo.service;

import com.shoes.demo.domain.query.TestQuery;
import com.shoes.demo.domain.vo.TestVO;

/**
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/

public interface TestService {
    public TestVO serv(TestQuery query);
}
