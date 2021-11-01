package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.vo.ShoppingCartVO;

/**
 * @authur tc
 * @date 2021/11/1 15:48
 */
public interface ShoppingCartService {

    /**
     * 添加到购物车
     * @param shoppingCartVO
     * @return
     */
    String addToShoppingCart(ShoppingCartVO shoppingCartVO);

    /**
     * 获取购物车商品列表
     * @param userId
     * @return
     */
    ShoppingCartVO getShoppingCartGoods(String userId);
}
