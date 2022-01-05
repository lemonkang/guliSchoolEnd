package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.object.AllSubjectList;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api("课程管理")
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

//      课程管理上传Excel
    @ApiOperation("课程管理上传Excel")
    @PostMapping("excelupload")
    public R excelupload(
            @ApiParam(name = "file",value = "文件")
          MultipartFile file){
       eduSubjectService.excelUpload(file,eduSubjectService);
        return  R.ok();
    }
//    获取所有课程
    @ApiOperation("获取所有课程")
    @GetMapping("listsubject")
    public R listsubject(){
        List<AllSubjectList> allSubject = eduSubjectService.getAllSubject();

        return R.ok().data("AllSubjectList",allSubject);

    }

}
