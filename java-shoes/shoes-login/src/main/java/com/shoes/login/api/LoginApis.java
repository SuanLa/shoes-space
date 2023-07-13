package com.shoes.login.api;

import com.nimbusds.jose.JOSEException;
import com.shoes.common.ResultVO;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.query.LogOutQuery;
import com.shoes.login.domin.vo.LoginVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
public interface LoginApis {
    /**
     * @param loginDTO 登录实体
     * @return 返回登录数据
     * @throws NoSuchAlgorithmException
     * @throws JOSEException
     */
    ResultVO<LoginVO> login(LoginDTO loginDTO) throws NoSuchAlgorithmException, JOSEException;

    /**
     * @param logOutQuery 登录实体
     * @return 返回登出数据
     */
    ResultVO<String> loginOut(LogOutQuery logOutQuery);

    /**
     * @param logOutQuery token刷新实体
     * @return 返回token
     */
    ResultVO<String> refreshToken(LogOutQuery logOutQuery);
}
