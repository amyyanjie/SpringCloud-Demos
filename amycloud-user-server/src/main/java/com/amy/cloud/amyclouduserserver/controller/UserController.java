package com.amy.cloud.amyclouduserserver.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/29 15:29
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("/get")
    public String getUserName(String userId) {
        return "2:getUserName userId:" + userId;
    }

    @PostMapping("/add")
    public String addUser(String mobile, String nickName) {
        return "addUser,mobile=" + mobile + ",nickName=" + nickName;
    }

    @GetMapping("/list/{role}")
    String getUserList(@PathVariable("role") String role) {
        return "getUserList:role=" + role;
    }

    @GetMapping("/test")
    public String test() {
        return "abdc";
    }
}
