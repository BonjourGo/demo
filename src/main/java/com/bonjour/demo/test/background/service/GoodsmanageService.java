package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.vo.GoodsVO;

/**
 * @authur tc
 * @date 2021/11/2 15:32
 */
public interface GoodsmanageService {

    /**
     * 添加商品
     * @param goodsVO
     * @return
     */
    String addGoods(GoodsVO goodsVO);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    String add(Goods goods);
}
