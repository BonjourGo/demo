package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.ESService;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur tc
 * @date 2021/11/17 11:36
 */
@Api("es API")
@RestController
@RequestMapping("/es")
public class ESController {

    @Autowired
    private ESService esService;

    @ApiOperation("保存到es")
    @PostMapping("saveToES")
    public Result saveToES(@RequestBody User user) {
        esService.saveToES(user);
        return Result.ok();
    }
}
