package com.huayutech.springsessionrest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CookieController {

    @GetMapping("/test/cookie")
    String doTestCookie(HttpSession httpSession) {

        if (httpSession.getAttribute("magic") == null) {
            httpSession.setAttribute("magic", "Hello, World!");
            return "";
        }
        else {
            return (String)httpSession.getAttribute("magic");
        }

    }

}
