package com.bonjour.demo.test.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 唐超
 * @authur tc
 * @date 2021/9/27 14:40
 */
@Data
@TableName("user")
@ApiModel("用户表")
public class User implements Serializable {

    @TableId("id")
    @ApiModelProperty("主键")
    private String id;

    @TableField("nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField("log_status")
    @ApiModelProperty("登录状态 0 未登录 1 已登录")
    private String logStatus;

//    private String sex;
}
