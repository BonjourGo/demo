package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.background.mapper.GoodsMapper;
import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.utils.RedisUtils;
import com.bonjour.demo.test.common.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @authur tc
 * @date 2021/11/2 15:32
 */
@Service
public class GoodsmanageServiceImpl implements GoodsmanageService{

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public String addGoods(GoodsVO goodsVO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsVO, goods);
        Long goodsId = redisUtils.getIncrLongId("goodsId");
        goods.setId(goodsId);
        goods.setAddTime(new Date());
        goodsMapper.insert(goods);
        return "添加成功";
    }
}
