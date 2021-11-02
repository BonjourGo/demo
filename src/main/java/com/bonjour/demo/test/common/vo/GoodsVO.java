package com.bonjour.demo.test.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bonjour.demo.test.common.entity.GoodsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.springframework.aop.target.LazyInitTargetSource;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @authur tc
 * @date 2021/11/1 16:15
 */
@Data
@ApiModel("商品VO")
public class GoodsVO implements Serializable {

    private static final long serialVersionUID = -7783587746861538702L;

    @ApiModelProperty("店铺id")
    private String shopId;

    @ApiModelProperty("店铺名称")
    private String shopName;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("是否上架  0 未上架 1 已上架")
    private String isShelf;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("类型List")
    private List<GoodsType> types;
}
