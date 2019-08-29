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

    @GetMapping("/get")
    public String getUserName( String userId) {
        return remoteUserService.getUserName(userId);
    }

    @PostMapping("/add")
    public String addUser(String mobile, String nickName) {
        return remoteUserService.addUser(mobile, nickName);
    }

    @GetMapping("/list")
    public String getUserList(){
        return remoteUserService.getUserList();
    }

    @GetMapping("/test")
    public String test(){
        return "eefa";
    }
}
