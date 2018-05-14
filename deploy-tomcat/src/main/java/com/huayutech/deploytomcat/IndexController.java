package com.huayutech.deploytomcat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    private String doGet() {
        return "hello, spring boot!";
    }
}
