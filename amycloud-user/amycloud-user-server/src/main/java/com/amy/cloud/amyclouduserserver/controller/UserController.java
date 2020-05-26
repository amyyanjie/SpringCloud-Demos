package com.amy.cloud.amyclouduserserver.controller;

import com.amy.cloud.amyclouduserserver.models.User;
import org.springframework.validation.annotation.Validated;
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
    public String addUser(User user) {
        return "addUser,mobile=" + user.getMobile() + ",nickName=" + user.getNickName();
    }

    @GetMapping("/list/{role}")
    String getUserList(@PathVariable("role") String role) {
        return "getUserList:role=" + role;
    }

    @GetMapping("/test")
    public String test(String str) {
        return str.substring(3,8);
    }
}
