package com.zh.controller;


import com.zh.domain.CourseTopic;
import com.zh.domain.CourseVideo;
import com.zh.service.CourseTopicService;
import com.zh.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TopicController {


    @Autowired
    CourseVideoService courseVideoService;

    @Autowired
    CourseTopicService courseTopicService;

    // 专题页面
    @RequestMapping(value = "/topic/{topicId}")
    public String topicPage(@PathVariable Integer topicId, Model model) {
        model.addAttribute("focusIndex", 2);
        model.addAttribute("topicId", topicId);

        CourseTopic courseTopic  = courseTopicService.getCourseTopic(topicId);

        model.addAttribute("courseTopic",courseTopic);

        List<CourseVideo> courseVideoList = courseVideoService.getCourseVideoAll(topicId);

        model.addAttribute("courseVideoList",courseVideoList);

        model.addAttribute("video", courseVideoList.get(0));
        return "course_video";
    }

    // 具体某个视频播放
    @RequestMapping(value = "/topic/{topicId}/{videoId}")
    public String topicPage(@PathVariable Integer topicId, Model model ,@PathVariable Integer videoId) {
        model.addAttribute("focusIndex", 2);
        model.addAttribute("topicId", topicId);

        //获取topicId所对应的course_topic的对象
        CourseTopic courseTopic  = courseTopicService.getCourseTopic(topicId);

        model.addAttribute("courseTopic",courseTopic);

        //获取视频列表
        List<CourseVideo> courseVideoList = courseVideoService.getCourseVideoAll(topicId);

        model.addAttribute("courseVideoList",courseVideoList);


        //根据videoId返回对应的courseVideo对象
        CourseVideo courseVideo = courseVideoService.getCourseVideo(videoId);

        model.addAttribute("video",courseVideo);
        return "course_video";
    }
}
