package com.bonjour.demo.test.common.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/11/1 16:27
 */
@Data
@ApiModel("商品规格")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = -1428201338509750832L;

    // 主键
    private Long id;

    // 商品id
    private Long goodsId;

    // 名称
    private String name;

    // 库存
    private String stock;

    // 初始价格
    private BigDecimal originPrice;

    // 实时价格
    private BigDecimal actualPrice;

    // 添加时间
    private Date addTime;

    // 是否上架  0 未上架 1 已上架
    private String isShelf;
}
