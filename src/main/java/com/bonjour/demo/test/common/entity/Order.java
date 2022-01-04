package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/9/27 14:51
 */
@Data
@ApiModel("订单信息表")
@TableName("record")
public class Order {

    @TableId("id")
    @ApiModelProperty("主键")
    private String id;

    @TableField("user_id")
    @ApiModelProperty("用户id")
    private String userId;

    @TableField("goods_id")
    @ApiModelProperty("商品id")
    private String goodsId;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField("total_price")
    @ApiModelProperty("价格")
    private BigDecimal totalPrice;

    @TableField("address")
    @ApiModelProperty("地址")
    private String address;

    @TableField("goods_id")
    @ApiModelProperty("商品id")
    private String consignee;

    // 收货人电话
    private String phone;
}
