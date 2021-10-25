package com.bonjour.demo.test.background.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bonjour.demo.test.background.mapper.UserMapper;
//import com.bonjour.demo.test.background.service.TestService;
import com.bonjour.demo.test.background.service.TestService;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.QRCodeUtils;
import com.bonjour.demo.test.common.utils.RedisUtils;
import com.bonjour.demo.test.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @authur tc
 * @date 2021/9/27 9:34
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试controller")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TestService testService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String hello() {
        stringRedisTemplate.opsForValue().set("hello", "hello");
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
        System.out.println(redisUtils.getIncrId("888"));
        return "hello";

    }

    @GetMapping("/hello/{hello}")
    @ApiOperation("sayHello")
    public String sayHello(@PathVariable("hello") String hello) {
        return hello;

    }

    @GetMapping("/getUser")
    public List<User> getUser() {
        List<User> list = testService.getUser();
        return list;
    }

    @GetMapping("/getImage")
    @ApiOperation("二维码")
    public Result getImage() throws Exception {
        BufferedImage bufferedImage = QRCodeUtils.createImage("hello", null, false);
        return Result.ok(bufferedImage);
    }

}
