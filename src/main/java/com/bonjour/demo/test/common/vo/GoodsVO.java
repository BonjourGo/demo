package com.bonjour.demo.test.common.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/11/1 16:15
 */
@Data
@ApiModel("商品VO")
public class GoodsVO implements Serializable {

    private static final long serialVersionUID = -7783587746861538702L;

    // 名称
    private String name;

    // 库存
    private String stock;

    // 描述
    private String description;

    // 初始价格
    private BigDecimal originPrice;

    // 实时价格
    private BigDecimal actualPrice;

    // 是否上架  0 未上架 1 已上架
    private String isShelf;
}
