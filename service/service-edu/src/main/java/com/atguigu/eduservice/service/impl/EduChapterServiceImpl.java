package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper,EduChapter> implements EduChapterService {

    @Override
    public Boolean deleteChapterById(String chapterid) {
        boolean b = this.removeById(chapterid);
        return b;
    }
//根据课程id删除章节
    @Override
    public Boolean deleteChapterByCourseid(String courseid) {
        QueryWrapper<EduChapter> eduChapterQueryWrapper = new QueryWrapper<>();
        eduChapterQueryWrapper.eq("courseId",courseid);
        boolean remove = this.remove(eduChapterQueryWrapper);
        return remove;
    }
}
