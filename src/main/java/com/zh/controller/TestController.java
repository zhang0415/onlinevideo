package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(path = "/test.do")
    public String test1(){
        System.out.println("我被请求了");
        return "welcome";
    }
}
