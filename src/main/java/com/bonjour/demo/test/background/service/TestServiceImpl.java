package com.bonjour.demo.test.background.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bonjour.demo.test.background.mapper.UserMapper;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @authur tc
 * @date 2021/9/28 14:11
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> getUser() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getId, "121456456");
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        return list;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setNickName("chery" + i);
            user.setPhone("12345678" + i);
            list.add(user);
        }
        List<User> last = list.stream().filter(item -> !"chery1".equals(item.getNickName())).collect(Collectors.toList());
        System.out.println(last);

        List<User> first = list.stream().distinct().collect(Collectors.toList());
    }

}
