package com.shoes.login.service;

import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;

/**
 * @Author: Tomcat
 * @Date: 2023/7/8
 **/
public interface LoginService {

    LoginVO loginSrv(LoginDTO login);
}
