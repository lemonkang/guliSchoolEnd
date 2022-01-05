package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.object.AllSubjectList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EduSubjectService extends IService<EduSubject> {
    void excelUpload(MultipartFile file, EduSubjectService eduSubjectService);
//    获取所有课程
    List<AllSubjectList> getAllSubject();


}
