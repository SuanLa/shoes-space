package com.shoes.login.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import com.nimbusds.jose.JOSEException;
import com.shoes.common.ResultVO;
import com.shoes.common.entity.TokenEntity;
import com.shoes.common.util.JWTUtil;
import com.shoes.login.api.LoginApis;
import com.shoes.login.domin.dto.LoginDTO;
import com.shoes.login.domin.query.LogOutQuery;
import com.shoes.login.domin.vo.LoginVO;
import com.shoes.login.entity.LoginEntity;
import com.shoes.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("/login")
    @ApiOperation("登录接口")
    @Override
    public ResultVO<LoginVO> login(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException, JOSEException {
        LoginEntity loginEntity = service.loginSrv(loginDTO);
        if (loginEntity.getPasswd().equals(loginDTO.getPassword())){
            LoginVO loginVO = new LoginVO(loginEntity.getRoleName(), null);
            long id = IdUtil.getSnowflake(1, 1).nextId();
            String token = JWTUtil.getToken(new TokenEntity("login", System.currentTimeMillis(), System.currentTimeMillis() + 1000L, String.valueOf(id), loginEntity.getUsername()));
            loginVO.setToken(token);
            redisTemplate.opsForValue().set(loginEntity.getUsername(),token, Duration.ofMinutes(3));
            return ResultVO.success(loginVO);
        }else {
            return ResultVO.failed("密码错误");
        }
    }

    @GetMapping("/loginOut")
    @ApiOperation("登出接口")
    @Override
    @Valid
    public ResultVO<String> loginOut(@RequestBody LogOutQuery logOutQuery) {
        Boolean delete = redisTemplate.delete(logOutQuery.getUsername());
        if (delete){
            return ResultVO.success("删除成功");
        }
        return ResultVO.failed("删除失败");
    }

    @GetMapping("/refresh")
    @ApiOperation("刷新token")
    @Override
    public ResultVO<String> refreshToken(LogOutQuery logOutQuery) {
        Boolean expire = redisTemplate.expire(logOutQuery.getUsername(), Duration.ofMinutes(3));
        if (expire){
            return ResultVO.success("更新成功");
        }
        return ResultVO.failed("更新失败");
    }
}
