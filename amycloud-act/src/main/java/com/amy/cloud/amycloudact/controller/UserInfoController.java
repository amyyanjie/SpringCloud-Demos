package com.amy.cloud.amycloudact.controller;

import com.amy.cloud.amycloudact.service.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 11:39
 */
@RestController
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    RemoteUserService remoteUserService;
//    @Autowired
//    private UserServiceFeign userServiceFeign;

    @GetMapping("/get")
    public String getUserName( String userId) {
        return remoteUserService.getUserName(userId);
    }

    @PostMapping("/add1")
    public String add1User(String mobile, String nickName) {
        return remoteUserService.addUser(mobile, nickName);
    }

//    @PostMapping("/add2")
//    public String add2User(String mobile, String nickName) {
//        return userServiceFeign.addUser(mobile, nickName);
//    }

//    @GetMapping("/list")
//    public String getUserList(@RequestParam String role){
//        return userServiceFeign.getUserList(role);
//    }

    @GetMapping("/test")
    public String test(){
        return "eefa";
    }
}
