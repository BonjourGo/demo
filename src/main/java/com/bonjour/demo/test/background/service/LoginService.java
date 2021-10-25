package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @authur tc
 * @date 2021/10/9 14:31
 */
public interface LoginService {

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    String login(User user, HttpServletRequest request);

    /**
     * 退出登录
     * @param request
     * @return
     */
    String logout(String userId, HttpServletRequest request);
}
