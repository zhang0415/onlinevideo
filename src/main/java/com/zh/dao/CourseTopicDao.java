package com.zh.dao;


import com.zh.domain.CourseTopic;

import java.util.HashMap;
import java.util.List;

public interface CourseTopicDao {

    int insertCourseTopic(CourseTopic courseTopic);

    List<CourseTopic> findCourseTopicByCondition(HashMap<String,Object> map);
}
