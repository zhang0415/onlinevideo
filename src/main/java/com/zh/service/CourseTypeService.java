package com.zh.service;

import com.zh.domain.CourseType;

import java.util.List;

public interface CourseTypeService {
    int insertCourseType(CourseType courseType);

    List<CourseType> getAllCourseType();
}
