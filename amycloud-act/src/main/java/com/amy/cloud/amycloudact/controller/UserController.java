package com.amy.cloud.amycloudact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/12 19:04
 */
@RestController
public class UserController {


    @GetMapping("/user/time")
    public String getTime() {
        return null;
    }

}
