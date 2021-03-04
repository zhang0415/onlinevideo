package com.zh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zh.dao.CourseTopicDao;
import com.zh.domain.CourseTopic;
import com.zh.service.CourseTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CourseTopicServiceImpl implements CourseTopicService {
    @Autowired
    CourseTopicDao courseTopicDao;


    @Override
    //课程编号查询
    public PageInfo<CourseTopic> getIndexCourseTopic(int typeId) {
        HashMap<String,Object> map = new HashMap();
        map.put("typeId",typeId);
        map.put("flag",1);
        List<CourseTopic> list = courseTopicDao.findCourseTopicByCondition(map);

        PageInfo<CourseTopic> pageInfo = new PageInfo<>(list,4);
        return pageInfo;
    }

    @Override
    //最新查询
    public PageInfo<CourseTopic> getIndexNewestTopic() {
        HashMap<String,Object> map = new HashMap();
        map.put("order",1);
        List<CourseTopic> list = courseTopicDao.findCourseTopicByCondition(map);
        PageInfo<CourseTopic> pageInfo = new PageInfo<>(list,4);
        return pageInfo;
    }

    @Override
    public CourseTopic getCourseTopic(int topicId) {
        List<Integer> ids = new ArrayList<>();
        ids.add(topicId);
        List<CourseTopic> list = courseTopicDao.findCourseTopicByIds(ids);
        return list.get(0);
    }
}
