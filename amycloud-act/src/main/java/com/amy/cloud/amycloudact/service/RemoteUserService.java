package com.amy.cloud.amycloudact.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 14:14
 */
//@Component
@FeignClient(name = "amycloud-user")
public interface RemoteUserService {
    @GetMapping("/user/get/{userId}")
    String getUserName(@PathVariable String userId);

    @PostMapping("/user/add")
    String addUser(@RequestParam String mobile, @RequestParam("nickName") String nickName);


}
