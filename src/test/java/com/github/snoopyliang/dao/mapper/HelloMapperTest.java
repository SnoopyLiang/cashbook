package com.github.snoopyliang.dao.mapper;

import com.alibaba.fastjson.JSON;
import com.github.snoopyliang.CashbookApplicationTests;
import com.github.snoopyliang.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by yuyokun on 2017/8/27.
 */
@Slf4j
public class HelloMapperTest extends CashbookApplicationTests{
    @Autowired
    private HelloMapper helloMapper;

    @Test
    public void getNameById() throws Exception {
//        User name = helloMapper.getNameById(1);
        User name = helloMapper.selectById(1);
        log.info("name:{}", JSON.toJSON(name));
    }

}