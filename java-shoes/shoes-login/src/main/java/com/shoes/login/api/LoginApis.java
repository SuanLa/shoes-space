package com.shoes.login.api;

import com.shoes.common.ResultVO;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
public interface LoginApis {
    ResultVO<LoginVO> login(LoginDTO loginDTO);

    ResultVO<LoginVO> loginOut(LoginDTO loginDTO);
}
