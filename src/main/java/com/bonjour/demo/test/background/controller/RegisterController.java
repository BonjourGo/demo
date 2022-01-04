package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.UserService;
import com.bonjour.demo.test.common.entity.Address;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.RedisUtils;
import com.bonjour.demo.test.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @authur tc
 * @date 2021/10/12 10:14
 */
@RestController
@RequestMapping("/register")
@Api("注册controller")
@Slf4j
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    JedisPool jedisPool;

    @ApiOperation("注册")
    @PostMapping( "/register")
    public Result register(@RequestBody User user) {
        try {
//            log.info("---------------------");
//            Jedis jedis = jedisPool.getResource();
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            redisUtils.releaseDistributedLock(jedis, user.getPhone(), uuid);
            userService.register(user);
//            redisUtils.releaseDistributedLock(jedis, user.getPhone(), uuid);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return Result.ok("注册成功");
    }

    @ApiOperation("注销")
    @GetMapping("cancel")
    public Result cancel(String phone) {
        userService.cancel(phone);
        return Result.ok("注销成功！");
    }

    @ApiOperation("添加收货地址")
    @PostMapping("/address")
    public Result address(@RequestBody Address address) {
        userService.address(address);
        return Result.ok("添加成功！");
    }

    @ApiOperation("修改收件地址")
    @PostMapping("/updateAddress")
    public Result updateAddress(@RequestBody Address address) {
        userService.updateAddress(address);
        return Result.ok("修改成功");
    }

}
