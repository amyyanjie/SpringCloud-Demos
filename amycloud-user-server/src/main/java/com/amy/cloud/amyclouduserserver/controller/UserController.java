package com.amy.cloud.amyclouduserserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/29 15:29
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("/get")
    public String getUserName( String userId) {
        return "getUserName userId:"+userId;
    }

    @PostMapping("/add")
    public String addUser(String mobile, String nickName) {
        return "addUser,mobile="+mobile+",nickName="+nickName;
    }

    @GetMapping("/list")
    public String getUserList(){
        return "getUserList";
    }

    @GetMapping("/test")
    public String test(){
        return "abdc";
    }
}
