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
 * @date 2021/11/19 16:57
 */
@Data
@ApiModel("秒杀商品")
@TableName("skill_goods")
public class SkillGoods implements Serializable {

    private static final long serialVersionUID = -1282387429864652346L;

    @TableId("id")
    @ApiModelProperty("主键")
    private String id;

    @TableField("goods_id")
    @ApiModelProperty("商品id")
    private Long goodId;

    @TableField("goods_name")
    @ApiModelProperty("商品名称")
    private String name;

    @TableField("skill_price")
    @ApiModelProperty("秒杀价格")
    private BigDecimal skillPrice;

    @TableField("stock")
    @ApiModelProperty("秒杀数量")
    private Integer stock;

    @TableField("start_Time")
    @ApiModelProperty("开始时间")
    private Date startTime;

    @TableField("end_time")
    @ApiModelProperty("结束时间")
    private Date endTime;

    @TableField("version")
    @ApiModelProperty("版本号")
    private Integer version;
}
