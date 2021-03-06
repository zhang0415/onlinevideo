package com.zh.service.impl;

import com.zh.dao.CourseTypeDao;
import com.zh.domain.CourseType;
import com.zh.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    CourseTypeDao courseTypeDao;

    @Override
    public int insertCourseType(CourseType courseType) {
        return courseTypeDao.insertCourseType(courseType) ;
    }

    @Override
    public List<CourseType> getAllCourseType() {
        return courseTypeDao.findCourseTypeAll();
    }
}
