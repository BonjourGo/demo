package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.ShoppingCartService;
import com.bonjour.demo.test.common.utils.Result;
import com.bonjour.demo.test.common.vo.ShoppingCartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @authur tc
 * @date 2021/11/1 15:47
 */
@Api("购物车API")
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation("添加到购物车")
    @PostMapping("/addToShoppingCart")
    public Result addToShoppingCart(@RequestBody ShoppingCartVO shoppingCartVO) {
        String res = shoppingCartService.addToShoppingCart(shoppingCartVO);
        return Result.ok(res);
    }

    @ApiOperation("删除购物车商品")
    @PostMapping("/deleteShoppingCartGoods")
    public Result deleteShoppingCartGoods() {
        return Result.ok();
    }

    @ApiOperation("获取购物车商品列表")
    @GetMapping("/getShoppingCartGoods")
    public Result getShoppingCartGoods(String userId) {
        ShoppingCartVO shoppingCartVO = shoppingCartService.getShoppingCartGoods(userId);
        return Result.ok(shoppingCartVO);
    }
}
