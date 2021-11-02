package com.bonjour.demo.test.background.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.vo.ShoppingCartGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @authur tc
 * @date 2021/11/1 17:18
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {


    /**
     * 查询购物车内数据详情
     * @param idList
     * @return
     */
    List<ShoppingCartGoods> getList(@Param("idList") List<String> idList);
}
