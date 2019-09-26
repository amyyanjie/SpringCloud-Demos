package com.amy.cloud.amyclouduserserver.controller;

import com.amy.cloud.pub.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/06 10:38
 */
@Controller
@Slf4j
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redirect")
    public String testRedirect() {
        log.info("LoginController,testRedirect");
        return "redirect:hello.html";
    }

    @GetMapping("/token")
    @ResponseBody
    public String getToken() {
        this.redisUtil.set("key1", "value1", 100L);
        String value1= (String) this.redisUtil.get("key1");
        log.info(value1);
        return value1;
    }
}
