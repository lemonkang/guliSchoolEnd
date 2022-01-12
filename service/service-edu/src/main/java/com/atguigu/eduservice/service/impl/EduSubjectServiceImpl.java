package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.entity.InputVO.AllSubjectList;
import com.atguigu.eduservice.entity.InputVO.Subject;
import com.atguigu.eduservice.listener.ExcelListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
//获取所有课程
    @Override
    public List<AllSubjectList> getAllSubject() {
//        获取所有一级目录
        QueryWrapper<EduSubject> eduSubjectQueryWrapper = new QueryWrapper<>();
        eduSubjectQueryWrapper.eq("parent_id","0");
        List<EduSubject> onelist = this.list(eduSubjectQueryWrapper);
//        获取所有二级目录
        QueryWrapper<EduSubject> eduSubjectQueryWrapper1 = new QueryWrapper<>();
        eduSubjectQueryWrapper1.ne("parent_id","0");
        List<EduSubject> twolist = this.list(eduSubjectQueryWrapper1);
//        遍历所有一级目录同时对应二级目录
        ArrayList<AllSubjectList> allSubjectLists = new ArrayList<>();
        for (int i = 0; i < onelist.size(); i++) {
            AllSubjectList allSubjectList = new AllSubjectList();
            allSubjectList.setTitle(onelist.get(i).getTitle());

            ArrayList<Subject> childsubjects = new ArrayList<>();
            for (int j = 0; j < twolist.size(); j++) {
//                一级的id
                String parentid=onelist.get(i).getId();
//                当前二级对象
                EduSubject eduSubject = twolist.get(j);
                if (eduSubject.getParentId().equals(parentid)){
                    Subject subject = new Subject();
                    subject.setTitle(eduSubject.getTitle());
                    childsubjects.add(subject);
                }
            }
            allSubjectList.setChildren(childsubjects);
               allSubjectLists.add(allSubjectList);
        }

        return allSubjectLists;
    }


}
