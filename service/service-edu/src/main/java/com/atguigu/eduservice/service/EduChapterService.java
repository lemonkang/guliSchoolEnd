package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EduChapterService extends IService<EduChapter> {
    Boolean deleteChapterById(String chapterid);

    Boolean deleteChapterByCourseid(String courseid);
}
