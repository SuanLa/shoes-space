package com.shoes.login.service;

import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;
import com.shoes.login.entity.LoginEntity;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
public interface LoginService {

    LoginEntity loginSrv(LoginDTO login);

    LoginEntity logoutSrv(LoginDTO dto);
}
