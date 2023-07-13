package com.shoes.login;

import cn.hutool.core.codec.Base62;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.nimbusds.jose.*;
import com.shoes.login.entity.LoginEntity;
import com.shoes.common.entity.TokenEntity;
import com.shoes.login.mapper.LoginMapper;
import com.shoes.common.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

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

    @Test
    void snowFalk(){
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        System.out.println(snowflake.nextId());
    }

    @Test
    void base62(){
        System.out.println(System.currentTimeMillis());
        String encode = Base62.encode("123456");
        System.out.println(encode);
    }

    @Test
    void jwt() throws JOSEException, NoSuchAlgorithmException, ParseException {
        TokenEntity tokenEntity = new TokenEntity("login",1000L,1200L,"1564813","admin");
        String token = JWTUtil.getToken(tokenEntity);
        System.out.println(token);

        boolean validate = JWTUtil.validate(token);
        System.out.println(validate);
    }
}
