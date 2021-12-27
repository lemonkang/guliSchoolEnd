package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.listener.ExcelListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void excelUpload(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream,SubjectData.class,new ExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
