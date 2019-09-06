package com.amy.cloud.amyclouduserserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: yanjie
 * @Description:
 * @Date: 2019/09/06 10:38
 */
@Controller
@Slf4j
public class LoginController {
    @GetMapping("/redirect")
    public String testRedirect() {
        log.info("LoginController,testRedirect");
        return "redirect:hello.html";
    }
}
