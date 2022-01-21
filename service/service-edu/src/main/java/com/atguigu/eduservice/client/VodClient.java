package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.InputVO.VideoID;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient("service-vod")
@Component
public interface VodClient {
    @DeleteMapping("/admin/vod/video/deletevideo")
    public R deleteVideo(@ApiParam("删除视频的id") @RequestParam("videoID") String videoID);
    /*根据课程id删除课程*/
    @DeleteMapping("/admin/vod/video/deleteVideoByCourseId")
    public R deleteVideoByCourseId(@RequestParam("sourceIdStrings") ArrayList<String> sourceIdStrings);
}
