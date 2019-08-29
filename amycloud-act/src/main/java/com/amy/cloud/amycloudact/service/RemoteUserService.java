package com.amy.cloud.amycloudact.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/23 14:14
 */
//@Component
//程序启动后，会进行包扫描，扫描所有的@ FeignClient的注解的类，并将这些信息注入到ioc容器中
@FeignClient(name = "amycloud-user-server")
public interface RemoteUserService {
    @GetMapping("/user/get")
    //feign中@PathVariable、@RequestParam必须制定参数名
    String getUserName(@RequestParam("userId") String userId);

    @PostMapping("/user/add")
    String addUser(@RequestParam("mobile") String mobile, @RequestParam("nickName") String nickName);
}
