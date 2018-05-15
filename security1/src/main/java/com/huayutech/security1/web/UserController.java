package com.huayutech.security1.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping
    private Principal doGet(Principal principal) {
        return principal;
    }

    @RequestMapping("/delete")
    private String doDelete() {
        return "user delete";
    }

}
