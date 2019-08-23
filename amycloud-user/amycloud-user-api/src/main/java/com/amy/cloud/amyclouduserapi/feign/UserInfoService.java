//package com.amy.cloud.amyclouduserapi.feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient("amycloud-user-biz")
//public interface UserInfoService {
//    @GetMapping("/get/{userId}")
//    String getUserName(@RequestParam int userId);
//
//    @PostMapping("/add")
//    String addUser(@RequestParam String mobile, @RequestParam String nickName);
//}
