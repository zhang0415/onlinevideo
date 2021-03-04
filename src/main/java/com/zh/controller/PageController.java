package com.zh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zh.dao.BannerDao;
import com.zh.domain.*;
import com.zh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    CourseTopicService courseTopicService;

    @Autowired
    BannerService bannerService;

    @Autowired
    CourseTypeService courseTypeService;

    @Autowired
    ToolsItemService toolsItemService;

    @Autowired
    ToolsTypeService toolsTypeService;
    //首页
    @RequestMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("focalIndex",1);
        //轮播内容
        List<Banner> listBanner = bannerService.getIndexBanner();

        // 最新
        // 设置分页 第几页，显示N个
        PageHelper.startPage(1,4);
        PageInfo<CourseTopic> listIndex = courseTopicService.getIndexCourseTopic(4);

        //最新的课程
        PageHelper.startPage(1,4);
        PageInfo<CourseTopic> listNews = courseTopicService.getIndexNewestTopic();

        model.addAttribute("listIndex",listIndex);

        model.addAttribute("listNews",listNews);

        model.addAttribute("listBanner",listBanner);

        return "index";
    }


    //课程分类（所有分类）
    @RequestMapping("/course_list")
    public String courseList(Model model){
        model.addAttribute("focalIndex",2);
        //typeId初始值是1
        model.addAttribute("typeId", 0);

        PageHelper.startPage(1,16);
        //显示最新数据
        PageInfo<CourseTopic> listAllNews = courseTopicService.getIndexNewestTopic();

        //查询所有的type类型
        List<CourseType> allCourseType = courseTypeService.getAllCourseType();

        model.addAttribute("allCourseType",allCourseType);

        model.addAttribute("listAllNews",listAllNews);

        return "course_list";
    }




    //课程列表，显示所有分类
    @RequestMapping(value = "/course_list/type/{typeId}")
    public String courseList(@PathVariable Integer typeId, Model model, Integer pageNum) {
        model.addAttribute("typeId", typeId);
        model.addAttribute("focusIndex", 2);

        if (pageNum == null || pageNum <= 1) {
            pageNum = 1;
        }

        //查询所有的type类型
        List<CourseType> allCourseType = courseTypeService.getAllCourseType();
        model.addAttribute("allCourseType",allCourseType);


        PageHelper.startPage(pageNum, 16);

        PageInfo<CourseTopic> courseTopicList = null;

        if (typeId == 0) {
            // 最新专题
            courseTopicList = courseTopicService.getIndexNewestTopic();
        } else {
            // 对应类型专题
            courseTopicList = courseTopicService.getIndexCourseTopic(typeId);
        }

        model.addAttribute("listAllNews",courseTopicList);
        return "course_list";
    }
    //会员
    @RequestMapping("/vip")
    public String vip(Model model){

        model.addAttribute("focalIndex",3);
        return "vip";
    }

    //直播
    @RequestMapping("/video")
    public String video(Model model){
        model.addAttribute("focalIndex",4);

        return "course_video";
    }

    //工具
    @RequestMapping("/tools")
    public String tools(Model model){
        model.addAttribute("focalIndex",5);

        model.addAttribute("toolsTypeId",0);

        PageHelper.startPage(1,16);

        //所有数据
        PageInfo<ToolsItem> toolsItemAll = toolsItemService.getToolsItemAll();

        //所有类型
        List<ToolsType> toolsAllType = toolsTypeService.getToolsTypeAll();

        model.addAttribute("toolsItemAll",toolsItemAll);

        model.addAttribute("toolsAllType",toolsAllType);

        return "tools";
    }

    //课程列表，显示所有分类
    @RequestMapping(value = "/toolsList/type/{toolsTypeId}")
    public String toolsList(@PathVariable Integer toolsTypeId, Model model, Integer pageNum) {
        model.addAttribute("toolsTypeId", toolsTypeId);
        model.addAttribute("focusIndex", 5);

        if (pageNum == null || pageNum <= 1) {
            pageNum = 1;
        }

        List<ToolsType> toolsAllType = toolsTypeService.getToolsTypeAll();
        model.addAttribute("toolsAllType",toolsAllType);

        PageHelper.startPage(pageNum, 16);

        PageInfo<ToolsItem> toolsItemAll = null;
        if (toolsTypeId == 0) {
            // 最新
            toolsItemAll = toolsItemService.getToolsItemAll();

        } else {
            // 对应类型
            toolsItemAll = toolsItemService.getToolsItem(toolsTypeId);
        }

        model.addAttribute("toolsItemAll", toolsItemAll);

        return "tools";
    }

}
