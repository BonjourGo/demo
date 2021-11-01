package com.bonjour.demo.test.common.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @authur tc
 * @date 2021/11/1 17:16
 */
@Data
@ApiModel("购物车VO")
public class ShoppingCartVO implements Serializable {

    private List<ShoppingCartGoods> list = new ArrayList<>();

    private String userId;
}
