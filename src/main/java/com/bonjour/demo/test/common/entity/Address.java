package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @authur tc
 * @date 2021/9/30 15:25
 */
@Data
@TableName("address")
@ApiModel("收件地址")
public class Address implements Serializable {

    @TableId("id")
    private String id;

    // 用户id
    @TableField("user_id")
    @ApiModelProperty("用户id")
    private String userId;

    // 所在地
    private String location;

    // 地址
    private String address;

    // 收货人
    private String consignee;

    // 收货人电话
    private String phone;

    // 标签 家 公司 学校
    private String tags;

    // 是否默认 默认 否
    private String isDefault;

    // 添加时间
    private Date addTime;
}
