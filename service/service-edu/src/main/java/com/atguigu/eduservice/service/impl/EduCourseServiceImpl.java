package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.*;
import com.atguigu.eduservice.entity.InputVO.CourseInfo;
import com.atguigu.eduservice.entity.outputVO.CoursePublishVo;
import com.atguigu.eduservice.entity.outputVO.EduCourseInfo;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper,EduCourse> implements EduCourseService {

//    引入educoursedescriptionservice对educoursedescription表进行修改
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Autowired
    private EduChapterService eduChapterService;
    @Autowired
    private EduVideoService eduVideoService;
    @Autowired
    private EduTeacherService eduTeacherService;
    @Autowired
    private EduSubjectService eduSubjectService;
    @Override
    public void insertCourseInfo(CourseInfo courseInfo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfo,eduCourse);
        boolean save = this.save(eduCourse);
        if (!save){
            try {
                throw  new Exception("新增课程失败");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        获取课程id
        String id = eduCourse.getId();
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfo,eduCourseDescription);
        eduCourseDescription.setId(id);
        boolean save1 = eduCourseDescriptionService.save(eduCourseDescription);

    }
//获取课程相关信息
    @Override
    public CoursePublishVo getPublishCourseInfo(String courseid) {

        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(courseid);
        return publishCourseInfo;
    }
//根据课程id删除课程章节小节以及课程描述
    @Override
    public Boolean deleteCourseById(String courseid) {
        Boolean aBoolean = eduVideoService.deleteVideoByCourseId(courseid);
        Boolean aBoolean1 = eduChapterService.deleteChapterByCourseid(courseid);
        eduCourseDescriptionService.ByCourseid(courseid);
        boolean b = this.removeById(courseid);
        return b;
    }

    @Override
    public ArrayList<EduCourseInfo> getAllCourseInfo() {
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted",0);
//获取所有的课程信息
        List<EduCourse> eduCourseList = this.list(queryWrapper);
        ArrayList<EduCourseInfo> eduCourseInfoList = new ArrayList<>();


//
        for (EduCourse edu:eduCourseList) {
//            根据教师id获取教师姓名
            String teacherId = edu.getTeacherId();
            EduTeacher eduTeacher = eduTeacherService.getById(teacherId);
            edu.setTeacherId(eduTeacher.getName());
//            根据课程分类id获取课程分类
            String subjectId = edu.getSubjectId();
            EduSubject eduSubject = eduSubjectService.getById(subjectId);
            if (eduSubject!=null){
                edu.setSubjectId(eduSubject.getTitle());
            }else{
                edu.setSubjectId("");
            }
            String subjectParentId = edu.getSubjectParentId();
            EduSubject eduParentSubject = eduSubjectService.getById(subjectParentId);
            if (eduParentSubject!=null){
                edu.setSubjectParentId(eduParentSubject.getTitle());
            }else {
                edu.setSubjectParentId("");
            }

//            根据课程id查询课程描述信息
            String id = edu.getId();
            EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getById(id);

            EduCourseInfo eduCourseInfo = new EduCourseInfo();
            eduCourseInfo.setDescription(eduCourseDescription.getDescription());
            BeanUtils.copyProperties(edu, eduCourseInfo);

           eduCourseInfoList.add(eduCourseInfo);


        }



        return eduCourseInfoList;
    }
}
