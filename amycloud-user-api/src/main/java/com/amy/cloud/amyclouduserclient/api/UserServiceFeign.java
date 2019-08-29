package com.amy.cloud.amyclouduserclient.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/08/29 16:42
 */
@Component
@FeignClient(name = "amycloud-user-server")
public interface UserServiceFeign {
    @GetMapping("/user/get")
        //feign中@PathVariable、@RequestParam必须制定参数名
    String getUserName(@RequestParam("userId") String userId);

    @PostMapping("/user/add")
    String addUser(@RequestParam("mobile") String mobile, @RequestParam("nickName") String nickName);

    @GetMapping("user/list/{role}")
    String getUserList(@PathVariable("role") String role);
}
