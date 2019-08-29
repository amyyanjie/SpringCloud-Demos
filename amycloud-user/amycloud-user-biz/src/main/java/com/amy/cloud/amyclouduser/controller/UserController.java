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
    @GetMapping("/user/get/{userId}")
    public String getUserName(@PathVariable("userId") String userId) {
        return "getUserName by userId :a" + userId;
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
        return "abdcd";
    }

    @GetMapping("/user/test1")
    public String test1(){
        return "abdcd";
    }

}
