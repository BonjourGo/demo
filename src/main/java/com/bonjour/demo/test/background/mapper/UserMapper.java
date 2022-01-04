package com.bonjour.demo.test.background.mapper;

import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.mapper.BaseMapperPro;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @authur tc
 * @date 2021/9/29 15:35
 */
@Mapper
public interface UserMapper extends BaseMapperPro<User> {

    @Select("select * from user where id = #{id}")
    List<User> getList(@Param("id") String id);

    User selectByPhone(@Param("s") String s);
}
