package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;

public class ExcelListener extends AnalysisEventListener<SubjectData> {
    public EduSubjectService eduSubjectService;


    public ExcelListener() {
    }
    public ExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }


    //    一行一行的获取数据
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        System.out.println(subjectData.getOneLevel());



    }
//   获取数据结束
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
