package com.bonjour.demo.test.background.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonjour.demo.test.common.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Max;

/**
 * @authur tc
 * @date 2021/10/22 14:39
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
