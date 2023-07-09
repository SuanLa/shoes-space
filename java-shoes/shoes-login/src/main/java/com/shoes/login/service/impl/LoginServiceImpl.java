package com.shoes.login.service.impl;

import cn.hutool.core.convert.Convert;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;
import com.shoes.login.entity.LoginEntity;
import com.shoes.login.mapper.LoginMapper;
import com.shoes.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public LoginVO loginSrv(LoginDTO login) {
        LoginEntity loginEntity = loginMapper.selectById(login.getUsername());
        return Convert.convert(LoginVO.class, loginEntity);
    }
}
