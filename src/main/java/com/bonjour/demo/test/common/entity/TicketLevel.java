package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @authur tc
 * @date 2021/10/22 16:23
 */
@Data
@ApiModel("票对应价格表")
@TableName("ticket_level")
public class TicketLevel {

    // 主键
    private String id;

    // 票主键
    private String ticketId;

    // 座位标识
    private String seatLevel;

    // 价格
    private BigDecimal price;
}
