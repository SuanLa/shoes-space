package com.shoes.login.controller;

import com.shoes.common.ResultVO;
import com.shoes.login.api.LoginApis;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @PostMapping("/login/{query}")
    @ApiOperation("登录接口")
    @ResponseBody
    @Override
    public ResultVO<LoginVO> login(LoginDTO loginDTO) {
        return null;
    }

    @GetMapping("/loginOut")
    @ApiOperation("登出接口")
    @ResponseBody
    @Override
    @Valid
    public ResultVO<LoginVO> loginOut(@RequestBody LoginDTO loginDTO) {
        return null;
    }
}
