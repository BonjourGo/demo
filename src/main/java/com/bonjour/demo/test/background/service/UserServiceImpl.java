package com.bonjour.demo.test.background.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bonjour.demo.test.background.mapper.AddressMapper;
import com.bonjour.demo.test.background.mapper.UserMapper;
import com.bonjour.demo.test.common.entity.Address;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @authur tc
 * @date 2021/10/12 10:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public void register(User user) {
        if (StringUtils.isBlank(user.getPhone())) {
            throw new RuntimeException("请输入手机号");
        }
        if (StringUtils.isNotBlank(user.getPassword()) && user.getPassword().length() < 6) {
            throw new RuntimeException("密码不能小于6位");
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getPhone, user.getPhone());
        if (userMapper.selectCount(lambdaQueryWrapper) > 0) {
            throw new RuntimeException("该手机号已注册！");
        }
        user.setId(redisUtils.getIncrId("user_id"));
        user.setLogStatus("0");
        userMapper.insert(user);
    }

    @Override
    public void cancel(String phone) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getPhone, phone);
        userMapper.delete(lambdaQueryWrapper);
    }

    @Override
    public void address(Address address) {
        address.setId(UUID.randomUUID().toString());
        addressMapper.insert(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateById(address);
    }
}
