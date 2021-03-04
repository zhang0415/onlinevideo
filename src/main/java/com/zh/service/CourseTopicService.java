package com.zh.service;

import com.github.pagehelper.PageInfo;
import com.zh.domain.CourseTopic;

import java.util.HashMap;
import java.util.List;

public interface CourseTopicService{

    PageInfo<CourseTopic> getIndexCourseTopic(int typeId);

    PageInfo<CourseTopic> getIndexNewestTopic();

    CourseTopic getCourseTopic(int topicId);
}
