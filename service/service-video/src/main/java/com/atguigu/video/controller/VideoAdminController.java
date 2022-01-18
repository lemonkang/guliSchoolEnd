package com.atguigu.video.controller;

import com.atguigu.commonutils.R;
import com.atguigu.video.service.VideoAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api("阿里云的视频点播")
@CrossOrigin
@RequestMapping("/admin/vod/video")
public class VideoAdminController {
    @Autowired
    private VideoAdminService videoAdminService;
    @ApiOperation("上传视频")
    @PostMapping("uploadvideo")
    public R upload(@ApiParam("上传的视频") @RequestBody MultipartFile file){
       String videoId= videoAdminService.uploadvideo(file);
       return R.ok().data("data",videoId);
    }

}
