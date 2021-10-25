package com.bonjour.demo.test.background.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @authur tc
 * @date 2021/9/30 16:15
 */
@Service
public class TicketServiceImpl implements TicketService{

    public static void main(String[] args) {
        String e = " ";
        System.out.println(StringUtils.isEmpty(e));
        System.out.println(StringUtils.isBlank(e));

    }
}
