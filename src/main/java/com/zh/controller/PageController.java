package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    //首页
    @RequestMapping(value = "/")
    public String indexPage() {
        return "index";
    }
    //工具
    @RequestMapping("/tools")
    public String tools(){
        return "tools";
    }
    //课程
    @RequestMapping("/course_list")
    public String course(){
        return "course_list";
    }
    //会员
    @RequestMapping("/vip")
    public String vip(){
        return "vip";
    }
}
