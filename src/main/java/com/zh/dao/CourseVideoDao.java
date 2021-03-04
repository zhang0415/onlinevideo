package com.zh.dao;


import com.zh.domain.CourseVideo;
import java.util.HashMap;
import java.util.List;

public interface CourseVideoDao {

    int insertCourseVideo(CourseVideo courseVideo);

    //根据条件参数查询数据列表
    List<CourseVideo> findCourseVideoByCondition(HashMap<String, Object> map);

    //根据主键查询数据
    CourseVideo findCourseVideoByIds(List<Integer> ids);


}
