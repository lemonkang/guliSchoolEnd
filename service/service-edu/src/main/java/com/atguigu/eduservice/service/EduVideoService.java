package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EduVideoService extends IService<EduVideo> {
    Boolean deleteVideo(String videoId);
}
