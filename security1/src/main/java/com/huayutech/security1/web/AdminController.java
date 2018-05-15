package com.huayutech.security1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    private String doGet() {
        return "admin controller";
    }

    @RequestMapping("/delete")
    private String doDelete() {
        return "admin delete";
    }
}
