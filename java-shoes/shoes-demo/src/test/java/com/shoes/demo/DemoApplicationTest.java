package com.shoes.demo;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
@SpringBootTest
public class DemoApplicationTest {
    @Test
    public void test(){

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();

//        System.out.println(id);
//        long id = IdUtil.getSnowflakeNextId();

//        String id = IdUtil.getSnowflakeNextIdStr();
        System.out.println(id);

    }
}
