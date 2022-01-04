package com.bonjour.demo.test.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @authur tc
 * @date 2021/11/17 17:45
 */
@Data
@ApiModel("user存入es数据库dto")
@Document(indexName = "user", type = "_doc", shards = 6, replicas = 3)
public class ESUserDTO implements Serializable {

    private static final long serialVersionUID = 8146622230976943067L;

    @Field(type = FieldType.Text)
    @ApiModelProperty("主键")
    private String id;

    @Field(type = FieldType.Text)
    @ApiModelProperty("昵称")
    private String nickName;

    @Field(type = FieldType.Text)
    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("登录状态 0 未登录 1 已登录")
    private String logStatus;
}
