package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/9/27 14:51
 */
@Data
@TableName("record")
public class Order {

    // 主键
    private String id;

    private String userId;

    private String ticketId;

    private Date createTime;

    // 数量
    private Integer number;

    // 价格
    private BigDecimal totalPrice;

    // 地址
    private String address;

    // 收货人
    private String consignee;

    // 收货人电话
    private String phone;
}
