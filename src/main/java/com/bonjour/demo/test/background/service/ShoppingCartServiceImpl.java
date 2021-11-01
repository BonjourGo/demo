package com.bonjour.demo.test.background.service;

import com.bonjour.demo.test.background.mapper.GoodsMapper;
import com.bonjour.demo.test.background.mapper.GoodsTypeMapper;
import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.utils.RedisUtils;
import com.bonjour.demo.test.common.vo.ShoppingCartGoods;
import com.bonjour.demo.test.common.vo.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车实现类
 * @authur tc
 * @date 2021/11/1 15:48
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addToShoppingCart(ShoppingCartVO shoppingCartVO) {
        List<ShoppingCartGoods> goodsList = shoppingCartVO.getList();
        if (goodsList.size() == 0) {
            throw new RuntimeException("请选择商品添加！");
        }
        // 获取之前是否有购物车数据
        List<ShoppingCartGoods> preGoodsList = (List<ShoppingCartGoods>) redisUtils.getCacheObject(shoppingCartVO.getUserId());
        if (!preGoodsList.isEmpty()) {
            // 存在数据
            // 判断这个商品是否添加过
            int index = 0;
            if (preGoodsList.stream().filter(s -> s.getGoodsTypeId().equals(goodsList.get(0).getGoodsTypeId())).count() == 1) {
                for (int i = 0; i < preGoodsList.size(); i++) {
                    if (preGoodsList.get(i).getGoodsTypeId().equals(goodsList.get(0).getGoodsTypeId())) {
                        index = i;
                    }
                }
                // 数量相加
                int total = goodsList.get(0).getNumber() + preGoodsList.get(index).getNumber();
                preGoodsList.remove(index);
                ShoppingCartGoods shoppingCartGoods = preGoodsList.get(index);
                shoppingCartGoods.setNumber(total);
                preGoodsList.add(shoppingCartGoods);
            }
        } else {
            // 不存在则直接放进缓存
            for (ShoppingCartGoods shoppingCartGoods : goodsList) {
                shoppingCartGoods.setAddTime(new Date());
            }
            preGoodsList.addAll(goodsList);
        }
        redisUtils.setCacheObject(shoppingCartVO.getUserId(), preGoodsList);
        return "添加成功";
    }

    @Override
    public ShoppingCartVO getShoppingCartGoods(String userId) {
        return null;
    }
}
