package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.common.entity.SkillGoods;

/**
 * @authur tc
 * @date 2021/11/22 14:43
 */
public interface SecKillService {

    /**
     * 添加商品到秒杀库
     * @param skillGoods
     * @return
     */
    Integer add(SkillGoods skillGoods);
}
