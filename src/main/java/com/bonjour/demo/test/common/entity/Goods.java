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
 * @date 2021/11/1 15:59
 */
@Data
@TableName("goods")
@ApiModel("商品实体类")
public class Goods implements Serializable {

    private static final long serialVersionUID = -7314929528703361432L;

    // 主键
    @TableId("id")
    @ApiModelProperty("主键")
    private Long id;

    @TableId("shop_id")
    @ApiModelProperty("店铺id")
    private String shopId;

    @TableId("shop_name")
    @ApiModelProperty("店铺名称")
    private String shopName;

    // 名称
    @TableField("name")
    @ApiModelProperty("名称")
    private String name;

    // 描述
    @TableField("description")
    @ApiModelProperty("描述")
    private String description;

    // 添加时间
    @TableField("add_time")
    @ApiModelProperty("添加时间")
    private Date addTime;

    // 是否上架  0 未上架 1 已上架
    @TableField("is_shelf")
    @ApiModelProperty("是否上架  0 未上架 1 已上架")
    private String isShelf;

    // 类型
    @TableField("type")
    @ApiModelProperty("类型")
    private String type;
}
