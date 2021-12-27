package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api("课程管理")
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation("上传Excel")
    @PostMapping("excelupload")
    public R excelupload(
            @ApiParam(name = "file",value = "文件")
          @RequestBody MultipartFile file){
       eduSubjectService.excelUpload(file,eduSubjectService);
        return  R.ok();
    }

}
