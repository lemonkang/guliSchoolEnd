package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.InputVO.CourseInfo;
import com.atguigu.eduservice.entity.outputVO.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
//    根据课程id查询 课程 教师 分类的信息
    @ApiOperation("根据课程id查询课程及其相关信息")
    @GetMapping("getPublishCourseInfo")
    public R getPublishCourseInfo(
            @ApiParam("课程id")
            @RequestParam("courseid") String courseid){
      CoursePublishVo coursePublishVo= eduCourseService.getPublishCourseInfo(courseid);
        return R.ok().data("coursePublishVo",coursePublishVo);
    }
    @ApiOperation("根据课程id删除课程，章节，小节，课程描述")
    @DeleteMapping("deleteCourseById")
    public R deleteCourseById(@RequestParam("courseid") String courseid){
      Boolean bool=  eduCourseService.deleteCourseById(courseid);
        return R.ok().data("bool",bool);
    }
}
