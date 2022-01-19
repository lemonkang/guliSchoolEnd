package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.outputVO.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse> {
  public CoursePublishVo getPublishCourseInfo(String courseid);
}
