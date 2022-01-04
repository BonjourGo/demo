package com.bonjour.demo.test.background.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bonjour.demo.test.background.mapper.UserMapper;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.AESUtils;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @authur tc
 * @date 2021/10/9 14:31
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public String login(User user, HttpServletRequest request) {
        if (StringUtils.isBlank(user.getPhone()) || StringUtils.isBlank(user.getPassword())) {
            throw new RuntimeException("请输入账号或密码！");
        }

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getPhone, user.getPhone()).eq(User::getPassword, AESUtils.encrypt(user.getPassword()));
        User login = userMapper.selectOne(lambdaQueryWrapper);
        if (login == null) {
            throw new RuntimeException("账号或密码错误！");
        }
        // 更新登录状态
        user.setLogStatus("1");
        userMapper.updateById(user);
        login.setLogStatus("1");
        // redis放入缓存
        redisUtils.setCacheObjectAndExpire(login.getId(), login, 60*60*24*5, TimeUnit.SECONDS);
        System.out.println(redisUtils.getCacheObject(login.getId()));
        request.getSession().setAttribute(login.getId(), login);
        return "登陆成功";
    }

    @Override
    public String logout(String userId, HttpServletRequest request) {
        redisUtils.deleteObject(userId);
        request.getSession().removeAttribute(userId);
        return null;
    }
}
