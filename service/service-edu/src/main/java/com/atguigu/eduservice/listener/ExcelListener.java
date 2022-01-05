package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

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
//
        /*
        * 先查找是否有一级目录   有获取id   没有生成获取id
        * 在获取二级目录  根据父的id和二级目录名字 有不创建   无创建
        * */
        addSubject(subjectData);
        System.out.println(subjectData.getOneLevel());


    }
//    增加数据
    public  void  addSubject(SubjectData subjectData){
        String oneLevel = subjectData.getOneLevel();
        String twoLevel = subjectData.getTwoLevel();
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",oneLevel).eq("parent_id",0);
        EduSubject one = eduSubjectService.getOne(queryWrapper, false);

//        一级的id
        String parentid;
        if(one==null){
            EduSubject eduSubject = new EduSubject();
            eduSubject.setTitle(oneLevel);
            eduSubjectService.save(eduSubject);
            EduSubject selectone = eduSubjectService.getOne(queryWrapper, false);
            parentid = selectone.getId();

        }else {
           parentid=one.getId();
        }
        //        查找二级有无
        QueryWrapper<EduSubject> queryWrappertwo = new QueryWrapper<>();
        queryWrappertwo.eq("title",twoLevel).eq("parent_id",parentid);
        EduSubject two = eduSubjectService.getOne(queryWrappertwo, false);
        if (two==null){
            EduSubject eduSubjectTwo = new EduSubject();
            eduSubjectTwo.setTitle(twoLevel);
            eduSubjectTwo.setParentId(parentid);
            eduSubjectService.save(eduSubjectTwo);
        }



    }
//   获取数据结束
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
