package com.zh.dao;

import com.zh.domain.CourseType;

import java.util.List;

public interface CourseTypeDao {
    int insertCourseType(CourseType courseType);

    List<CourseType> findCourseTypeAll();
}
