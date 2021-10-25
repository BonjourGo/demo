package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/9/27 14:46
 */
@Data
@TableName("ticket")
public class Ticket {

    // 主键
    @TableId("id")
    private String id;

    // 名称
    @TableField("ticket_name")
    private String ticketName;

    // 数量
    @TableField("number")
    private Integer number;

    // 状态 0 未开始 1 在售 2 已售光 3 售票结束
    private String status;

    // 开始时间
    private Date startTime;

    // 描述
    private String description;

    // 地点
    private String location;

    // 城市
    private String city;

    // 明星
    private String stars;


    private BigDecimal price;
}
