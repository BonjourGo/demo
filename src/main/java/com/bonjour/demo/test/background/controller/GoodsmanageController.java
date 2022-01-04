package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.GoodsmanageService;
import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.utils.Result;
import com.bonjour.demo.test.common.vo.GoodsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur tc
 * @date 2021/11/2 15:04
 */
@RestController
@RequestMapping("/goodsmanageController")
@Api(value = "商品管理controller")
public class GoodsmanageController {

    @Autowired
    private GoodsmanageService goodsmanageService;

    @ApiOperation("添加商品")
    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody GoodsVO goodsVO) {
        String msg = goodsmanageService.addGoods(goodsVO);
        return Result.ok(msg);
    }

    @ApiOperation("添加商品")
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        String msg = goodsmanageService.add(goods);
        return Result.ok(msg);
    }
}
