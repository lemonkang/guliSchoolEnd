package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/eduservice/chapter")
@Api("章节管理")
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;

    @ApiOperation("根据id删除章节")
    @DeleteMapping("deleteChapter")
    public R deleteChapter(@RequestParam("chapterid") String chapterid){
       Boolean bool= eduChapterService.deleteChapterById(chapterid);
        return  R.ok().data("bool",bool);
    }
    @ApiOperation("根据课程id删除章节")
    @DeleteMapping("deleteChapterByCourseid")
    public R deleteChapterByCourseid(@RequestParam("courseid") String courseid){
        Boolean bool= eduChapterService.deleteChapterByCourseid(courseid);
        return  R.ok().data("bool",bool);
    }
}
