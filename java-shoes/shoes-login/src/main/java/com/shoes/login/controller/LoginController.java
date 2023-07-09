package com.shoes.login.controller;

import com.shoes.common.ResultVO;
import com.shoes.login.api.LoginApis;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;
import com.shoes.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: Tomcat
 * @Date: 2023/7/7
 **/
@RestController
@RequestMapping("/admin")
@Validated
@Tag(name = "用户接口",description = "")
@Api("用户接口")
public class LoginController implements LoginApis {
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    @ApiOperation("登录接口")
    @Override
    public ResultVO<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        return ResultVO.success(service.loginSrv(loginDTO));
    }

    @GetMapping("/loginOut")
    @ApiOperation("登出接口")
    @Override
    @Valid
    public ResultVO<LoginVO> loginOut(@RequestBody LoginDTO loginDTO) {
        return null;
    }
}
