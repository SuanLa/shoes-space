package com.shoes.login.mapper;

import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.entity.LoginEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
@Repository
public interface LoginMapper {

    LoginEntity selectById(String username);
}
