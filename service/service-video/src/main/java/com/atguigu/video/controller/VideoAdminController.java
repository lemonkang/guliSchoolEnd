package com.atguigu.video.controller;

import com.atguigu.commonutils.R;
import com.atguigu.video.service.VideoAdminService;
import com.atguigu.video.vo.controller.VideoID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

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

    @ApiOperation("删除视频")
    @DeleteMapping("deletevideo")
    public R deleteVideo(
            @ApiParam("删除视频的id")
            @RequestParam("videoID") String videoID){

       Boolean bool= videoAdminService.deleteVideo(videoID);

        return R.ok().data("boolean",bool);
    }
//    根据视频id获取视频的URL
    @ApiOperation("根据视频id获取视频的URL")
    @GetMapping("getvideo")
    public R getvideo(
            @ApiParam("查询视频的id")
            @RequestParam("videoid") String videoid){
       String url= videoAdminService.getvideo(videoid);
        return R.ok().data("url",url);
    }
//    根据视频id获取视频的播放凭证
      @ApiOperation("根据视频id的播放凭证")
    @GetMapping("getVideoPlayAuth")
    public R getVideoPlayAuth(
            @ApiParam("根据id获取视频的播放凭证")
            @RequestParam("videoid") String videoid
      ){
      String auth= videoAdminService.getVideoPlayAuth(videoid);
        return R.ok().data("auth",auth);
      }
//      根据课程id删除多条视频
    @ApiOperation("根据课程id删除多条视频")
    @DeleteMapping("deleteVideoByCourseId")
    public R deleteVideoByCourseId(@RequestParam("sourceIdStrings")ArrayList<String> sourceIdStrings){
        String join = StringUtils.join(sourceIdStrings,",");
        Boolean bool= videoAdminService.deleteVideo(join);
        return R.ok().data("boolean",bool);
    }



}
