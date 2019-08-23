package com.amy.cloud.amyclouduser.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 11:07
 */
@RestController
public class UserController {

    @GetMapping("/user/get/{userId}")
    public String getUserName(@PathVariable("userId") String userId) {
        return "getUserName by userId:" + userId;
    }

    @PostMapping("/user/add")
    public String addUser(@RequestParam("mobile") String mobile, @RequestParam("nickName") String nickName) {
        return "mobile:" + mobile + ",nickName:" + nickName;
    }

    //    public String addUser(User user) {
//        return "mobile:" + user.getMobile() + ",nickName:" + user.getNickName();
//    }
}
