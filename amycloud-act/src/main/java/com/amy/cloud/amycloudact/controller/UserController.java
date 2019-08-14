package com.amy.cloud.amycloudact.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/12 19:04
 */
@RestController
@Slf4j
public class UserController {
    @Value("${springFestival.startTime}")
    public String startTime;


    @GetMapping("/user/time")
    public String getTime() {
        log.info("startTime:"+startTime);
        return startTime;
    }

}
