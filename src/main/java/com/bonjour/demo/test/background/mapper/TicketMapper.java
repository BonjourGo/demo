package com.bonjour.demo.test.background.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonjour.demo.test.common.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;

/**
 * @authur tc
 * @date 2021/10/22 16:31
 */
@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {
}
