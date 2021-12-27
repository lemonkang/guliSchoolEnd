package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

public interface EduSubjectService extends IService<EduSubject> {
    void excelUpload(MultipartFile file, EduSubjectService eduSubjectService);
}
