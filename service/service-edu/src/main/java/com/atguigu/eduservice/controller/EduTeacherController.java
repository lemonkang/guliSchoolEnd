package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("教师管理模块")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

//    查询表中所有数据
    @ApiOperation("获取teacher")
    @GetMapping("findAll")
    public void selectAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
    }
//    根据id删除老师
    @ApiOperation("根据教师id删除教师")
    @DeleteMapping("{id}")
    public R deleteTeacherById(
            @ApiParam(value = "教师id",required = true)
            @PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        return R.ok().data("data",b);

    }
//    错误
    @GetMapping("error")
    public void error(){
        int a=1/0;

    }
}
