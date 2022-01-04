package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.background.mapper.SkillGoodsMapper;
import com.bonjour.demo.test.common.entity.SkillGoods;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authur tc
 * @date 2021/11/22 14:43
 */
@Service
public class SecKillServiceImpl implements SecKillService{

    @Autowired
    private SkillGoodsMapper skillGoodsMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Integer add(SkillGoods skillGoods) {
        skillGoods.setId(redisUtils.getIncrId("skill_goods_id"));
        skillGoods.setVersion(1);
        return skillGoodsMapper.insert(skillGoods);
    }
}
