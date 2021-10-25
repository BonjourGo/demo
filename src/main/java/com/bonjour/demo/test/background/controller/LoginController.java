package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.LoginService;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @authur tc
 * @date 2021/10/9 14:29
 */
@RestController
@RequestMapping("/login")
@Api(value = "登录Api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        String msg = loginService.login(user, request);
        return Result.ok(msg);
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    public Result logout(String userId, HttpServletRequest request) {
        String msg = loginService.logout(userId, request);
        return Result.ok(msg);
    }
}
