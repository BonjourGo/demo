package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("goods_type")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = -1428201338509750832L;

    // 主键
    @TableId("id")
    @ApiModelProperty("主键")
    private Long id;

    // 商品id
    @TableField("goods_id")
    @ApiModelProperty("商品主键")
    private Long goodsId;

    // 名称
    @TableField("name")
    @ApiModelProperty("名称")
    private String name;

    // 库存
    @TableField("stock")
    @ApiModelProperty("库存")
    private Integer stock;

    // 初始价格
    @TableField("origin_price")
    @ApiModelProperty("初始价格")
    private BigDecimal originPrice;

    // 实时价格
    @TableField("actual_price")
    @ApiModelProperty("实时价格")
    private BigDecimal actualPrice;

    // 添加时间
    @TableField("add_time")
    @ApiModelProperty("添加时间")
    private Date addTime;

    @TableField("is_del")
    @ApiModelProperty("是否删除 0 未删除 1 已删除")
    private String isDel;
}
