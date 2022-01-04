package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.entity.User;

/**
 * @authur tc
 * @date 2021/11/17 20:48
 */
public interface ESService {

    /**
     * 保存到es
     * @param user
     */
    void saveToES(User user);
}
