package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.InputVO.CourseInfo;
import com.atguigu.eduservice.entity.outputVO.CoursePublishVo;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper,EduCourse> implements EduCourseService {

//    引入educoursedescriptionservice对educoursedescription表进行修改
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Autowired
    private EduChapterService eduChapterService;
    @Autowired
    private EduVideoService eduVideoService;
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
}
