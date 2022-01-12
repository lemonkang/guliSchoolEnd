package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.InputVO.CourseInfo;
import com.atguigu.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/course")
@Api("课程管理")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;



    @PostMapping("insertCourse")
    public R insertCourse(@RequestBody CourseInfo courseInfo){

            eduCourseService.insertCourseInfo(courseInfo);



        return R.ok();
    }
}
