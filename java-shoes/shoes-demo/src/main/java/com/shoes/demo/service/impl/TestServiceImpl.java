package com.shoes.demo.service.impl;

import com.shoes.demo.domin.dto.TestDTO;
import com.shoes.demo.domin.query.TestQuery;
import com.shoes.demo.domin.vo.TestVO;
import com.shoes.demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
@Service
public class TestServiceImpl implements TestService {
    @Override
    public TestVO serv(TestQuery query) {
        TestVO ok = new TestVO("OK");
        return ok;
    }
}
