package com.zh.controller;

import com.github.pagehelper.PageInfo;
import com.zh.domain.CourseTopic;
import com.zh.service.CourseTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    CourseTopicService courseTopicService;
    //首页
    @RequestMapping(value = "/")
    public String indexPage() {


        //typeId是3的课程
        PageInfo<CourseTopic> listIndex = courseTopicService.getIndexCourseTopic(4);

        //最新的课程
        PageInfo<CourseTopic> listNews = courseTopicService.getIndexNewestTopic(3);


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

    //直播
    @RequestMapping("/video")
    public String video(){
        return "course_video";
    }
}
