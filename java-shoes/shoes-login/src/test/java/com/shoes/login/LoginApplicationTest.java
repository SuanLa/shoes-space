package com.shoes.login;

import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.entity.LoginEntity;
import com.shoes.login.mapper.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
@SpringBootTest
public class LoginApplicationTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    void daoTest(){
        LoginEntity loginEntity = loginMapper.selectById("admin");
        System.out.println(loginEntity);
    }
}
