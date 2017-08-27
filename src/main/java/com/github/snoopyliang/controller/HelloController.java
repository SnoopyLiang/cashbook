package com.github.snoopyliang.controller;

import com.github.snoopyliang.dao.entity.User;
import com.github.snoopyliang.dao.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuyokun on 2017/8/26.
 */
@RestController
@RequestMapping("/helloController")
public class HelloController {
    @Autowired
    private HelloMapper helloMapper;

    @RequestMapping("/hello")
    public User sayHello() {
        return helloMapper.getNameById(1);
    }

}
