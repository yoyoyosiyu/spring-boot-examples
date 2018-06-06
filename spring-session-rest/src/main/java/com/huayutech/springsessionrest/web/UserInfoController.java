package com.huayutech.springsessionrest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfoController {

    @GetMapping("/userinfo")
    public Principal doGetUserInfo(Principal principal) {
        return principal;
    }

}
