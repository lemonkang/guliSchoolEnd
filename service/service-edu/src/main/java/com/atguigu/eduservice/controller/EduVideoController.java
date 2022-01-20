package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("小节管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/video")
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;

    @DeleteMapping("deleteVideo")
    public R  deleteVideo(@RequestParam("videoId") String videoId ){
       Boolean bool= eduVideoService.deleteVideo(videoId);

        return R.ok();
    }
}
