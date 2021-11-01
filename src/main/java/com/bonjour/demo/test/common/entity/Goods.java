package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
    private Long id;

    // 名称
    private String name;

    // 描述
    private String description;

    // 添加时间
    private Date addTime;

    // 是否上架  0 未上架 1 已上架
    private String isShelf;

    // 类型
    private String type;
}
