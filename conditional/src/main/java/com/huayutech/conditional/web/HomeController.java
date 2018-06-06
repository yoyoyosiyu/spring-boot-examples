package com.huayutech.conditional.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConditionalOnMissingBean({IndexController.class})
@RequestMapping("/")
public class HomeController {

    @ResponseBody
    @RequestMapping
    protected String doGet() {
        return "hello, world";
    }

}
