package com.bonjour.demo.test.background.controller;

import com.bonjour.demo.test.background.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur tc
 * @date 2021/9/30 16:13
 */
@RestController
@RequestMapping("/ticket")
@Api("票后台管理Api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

}
