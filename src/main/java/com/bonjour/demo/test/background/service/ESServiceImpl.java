package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.background.mapper.UserMapper;
import com.bonjour.demo.test.common.dto.ESUserDTO;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.AESUtils;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authur tc
 * @date 2021/11/17 20:48
 */
@Service
public class ESServiceImpl implements ESService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveToES(User user) {
        ESUserDTO esUserDTO = new ESUserDTO();
        user.setPassword(AESUtils.encrypt(user.getPassword()));
        user.setId(redisUtils.getIncrId("user_id"));
        BeanUtils.copyProperties(user, esUserDTO);
        userRepository.save(esUserDTO);
        userMapper.insert(user);
    }
}
