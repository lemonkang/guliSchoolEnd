package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.object.InsertEduTeacher;
import com.atguigu.eduservice.entity.object.PageQuery;
import com.atguigu.eduservice.entity.object.PageQueryWrapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api("教师管理模块")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    //1 查询讲师表所有数据
    @ApiOperation("获取teacher")
    @GetMapping("findAll")
    public R selectAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("list",list);
    }
//    2根据id删除老师
    @ApiOperation("根据教师id删除教师")
    @DeleteMapping("{id}")
    public R deleteTeacherById(
            @ApiParam(value = "教师id",required = true)
            @PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        return R.ok().data("data",b);

    }
    //3 分页查询讲师的方法
    //current 当前页
    //limit 每页记录数
    @ApiOperation("分页查询")
    @PostMapping("pagequery")
    public R pagination(
            @ApiParam(value = "分页对象")
            @RequestBody PageQuery pageQuery){
        Page<EduTeacher> page = new Page<>(pageQuery.getCurrent(), pageQuery.getLimit());
        IPage<EduTeacher> page1 = eduTeacherService.page(page, null);
        return R.ok().data("page",page1);
    }
    //4 条件查询带分页的方法
    @ApiOperation("分页查询带条件")
    @PostMapping("pagequerywrapper")
    public R paginationQueryWraper(
            @ApiParam("分页对象带参数")
            @RequestBody PageQueryWrapper pageQueryWrapper
    ) {
        Integer current=pageQueryWrapper.getCurrent();
        Integer limit=pageQueryWrapper.getLimit();
        String name=pageQueryWrapper.getName();
        Date createdate=pageQueryWrapper.getGmt_create();
        Date modifieddate=pageQueryWrapper.getGmt_modified();
        Page<EduTeacher> page = new Page<>(current, limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        QueryWrapper<EduTeacher> objectQueryWrapper = queryWrapper.like("name", name).between("gmt_create", createdate, modifieddate);
        IPage<EduTeacher> page1 = eduTeacherService.page(page, objectQueryWrapper);

        return R.ok().data("pagewraper",page1);
    }
    //讲师修改功能
    @ApiOperation("修改教师信息")
    @PostMapping("updateEduTeacher")
    public R updateEduTeacher(
            @ApiParam("修改教师内容")
            @RequestBody EduTeacher eduTeacher
    ){
        boolean b = eduTeacherService.updateById(eduTeacher);


        return R.ok().data("update",b);
    }
//    新增教师
    @ApiOperation("新增教师")
    @PostMapping("insertEduTeacher")
    public  R inserEduTeacher(
            @ApiParam("新增教师")
            @RequestBody InsertEduTeacher eduTeacher
    ){
        EduTeacher eduTeacher1 = new EduTeacher();
        eduTeacher.setName(eduTeacher.getName());
        eduTeacher.setSort(eduTeacher.getSort());

        return  R.ok();
    }

    //    错误
    @GetMapping("error")
    public void error(){
        int a=1/0;
    }
}
