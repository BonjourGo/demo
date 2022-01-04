package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.mapper.UserMapper;
//import com.bonjour.demo.test.background.service.TestService;
import com.bonjour.demo.test.background.service.TestService;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.mapper.CommonService;
import com.bonjour.demo.test.common.utils.QRCodeUtils;
import com.bonjour.demo.test.common.utils.RedisUtils;
import com.bonjour.demo.test.common.utils.Result;
import com.bonjour.demo.test.common.zookeeper.ZkLock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
@Slf4j
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
    private CommonService commonService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    @ApiOperation("hello")
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
    @ApiOperation("getUser")
    public List<User> getUser() {
        List<User> list = commonService.getMapper(UserMapper.class).query().eq("phone", "123456789").list();
        return list;
    }

    @GetMapping("/getImage")
    @ApiOperation("二维码")
    public Result getImage() throws Exception {
        BufferedImage bufferedImage = QRCodeUtils.createImage("hello", null, false);
        return Result.ok(bufferedImage);
    }

    @GetMapping("/insert")
    @ApiOperation("zookeeper 加锁测试")
    public Result insert() {
        ZkLock zkLock = new ZkLock();
        try {
            zkLock.lock();
            testService.insert();
        } catch (Exception e) {
            log.error(e.toString());
            throw new RuntimeException(e.toString());
        } finally {
            zkLock.unlock();
        }
        return Result.ok();
    }

}
