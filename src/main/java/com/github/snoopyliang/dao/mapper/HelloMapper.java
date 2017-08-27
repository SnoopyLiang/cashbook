package com.github.snoopyliang.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.snoopyliang.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by yuyokun on 2017/8/27.
 */
@Mapper
public interface HelloMapper extends BaseMapper<User>{

    @Select("select * from user where id = #{id}")
    User getNameById(@Param("id") int id);
}
