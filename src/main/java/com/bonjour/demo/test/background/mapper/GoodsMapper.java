package com.bonjour.demo.test.background.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonjour.demo.test.common.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @authur tc
 * @date 2021/11/1 17:18
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
