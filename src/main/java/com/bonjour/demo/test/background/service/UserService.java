package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.entity.Address;
import com.bonjour.demo.test.common.entity.User;

/**
 * @authur tc
 * @date 2021/10/12 10:18
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * 注销
     * @param phone
     */
    void cancel(String phone);

    /**
     * 添加收货地址
     * @param address
     */
    void address(Address address);

    /**
     * 修改收件地址
     * @param address
     */
    void updateAddress(Address address);
}
