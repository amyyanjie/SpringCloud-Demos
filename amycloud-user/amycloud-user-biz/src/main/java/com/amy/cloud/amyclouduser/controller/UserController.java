package com.amy.cloud.amyclouduser.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 11:07
 */
@RestController
public class UserController {

    //这里是SpringMVC，URL中的参数与方法中的参数名相同无需在注解中注明参数名
    @GetMapping("/user/get")
    public String getUserName(@RequestParam String userId) {
        return "getUserName by userId:" + userId;
    }

    @PostMapping("/user/add")
    public String addUser(@RequestParam String mobile, @RequestParam String nickName) {
        return "mobile:" + mobile + ",nickName:" + nickName;
    }

    @GetMapping("/user/list")
    public String getUserList() {
        return "getUserList" ;
    }

    @GetMapping("/user/test")
    public String test(){
        return "abd";
    }

}
