package com.bonjour.demo.test.common.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/11/1 16:21
 */
@Data
@ApiModel("购物车商品")
public class ShoppingCartGoods implements Serializable {

    private static final long serialVersionUID = -4687439326001988999L;

    // 商品主键
    private Long goodsId;

    // 商品规格主键
    private Long goodsTypeId;

    // 商品名称
    private String goodsName;

    // 商品规格名称
    private String goodsTypeName;

    // 库存
    private String stock;

    // 数量
    private Integer number;

    // 描述
    private String description;

    // 初始价格
    private BigDecimal originPrice;

    // 实时价格
    private BigDecimal actualPrice;

    // 添加时间
    private Date addTime;

    // 是否上架  0 未上架 1 已上架
    private String isShelf;
}
