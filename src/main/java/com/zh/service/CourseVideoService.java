package com.zh.service;


import com.zh.domain.CourseVideo;

import java.util.List;

public interface CourseVideoService {

    List<CourseVideo> getCourseVideoAll(int topicId);

    CourseVideo getCourseVideo(int vid);

}
