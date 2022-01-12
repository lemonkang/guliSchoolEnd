package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.InputVO.CourseInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EduCourseService extends IService<EduCourse> {
    void insertCourseInfo(CourseInfo courseInfo);
}