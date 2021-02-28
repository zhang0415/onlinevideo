package com.zh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zh.dao.CourseTopicDao;
import com.zh.domain.CourseTopic;
import com.zh.service.CourseTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseTopicServiceImpl implements CourseTopicService {
    @Autowired
    CourseTopicDao courseTopicDao;



    @Override
    //课程编号查询
    public PageInfo<CourseTopic> getIndexCourseTopic(int typeId) {
        PageHelper.startPage(1,4);
        HashMap<String,Object> map = new HashMap();
        map.put("typeId",typeId);
        map.put("flag",1);
        List<CourseTopic> list = courseTopicDao.findCourseTopicByCondition(map);
        PageInfo<CourseTopic> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    //最新查询
    public PageInfo<CourseTopic> getIndexNewestTopic(int limit) {
        PageHelper.startPage(1,4);
        HashMap<String,Object> map = new HashMap();
        map.put("order",1);
        List<CourseTopic> list = courseTopicDao.findCourseTopicByCondition(map);
        PageInfo<CourseTopic> pageInfo = new PageInfo<>(list);;
        return pageInfo;
    }
}
