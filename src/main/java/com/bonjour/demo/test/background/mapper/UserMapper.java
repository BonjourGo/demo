package com.bonjour.demo.test.background.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bonjour.demo.test.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.tomcat.websocket.BackgroundProcess;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @authur tc
 * @date 2021/9/29 15:35
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    List<User> getList(@Param("id") String id);
}
