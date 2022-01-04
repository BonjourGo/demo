package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.SecKillService;
import com.bonjour.demo.test.common.entity.SkillGoods;
import com.bonjour.demo.test.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur tc
 * @date 2021/11/22 14:22
 */
@RestController
@Api("seckill controller")
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    @ApiOperation("添加商品到秒杀库")
    @PostMapping("/add")
    private Result add(@RequestBody SkillGoods skillGoods) {
        return Result.ok(secKillService.add(skillGoods));
    }
}
