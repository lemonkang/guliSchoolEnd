package com.atguigu.eduservice.service.impl;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.InputVO.VideoID;
import com.atguigu.eduservice.mapper.EduVideoMapper;
import com.atguigu.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper,EduVideo> implements EduVideoService {
    //注入vodClient
    @Autowired
    private VodClient vodClient;
    @Override
    public Boolean deleteVideo(String videoId) {
//       先根据id进行查询
        QueryWrapper<EduVideo> eduVideoQueryWrapper = new QueryWrapper<>();
       eduVideoQueryWrapper.eq("id", videoId);
        EduVideo eduVideo = this.getOne(eduVideoQueryWrapper);
//           获取视频id
        String videoID = eduVideo.getVideoSourceId();

        vodClient.deleteVideo("8dd7a06641ab4811b31ddce1bb74feb4");
        int delete = baseMapper.delete(eduVideoQueryWrapper);

        return  delete==1;
    }
}
