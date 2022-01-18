package com.atguigu.video.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.atguigu.video.constant.ConstantPropertiesUtil;
import com.atguigu.video.service.VideoAdminService;
import com.atguigu.video.utils.AliyunVodSDKUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class VideoAdminServiceImpl implements VideoAdminService {

    @Override
    public String uploadvideo(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        try {
            InputStream inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(ConstantPropertiesUtil.Access_Key_Id, ConstantPropertiesUtil.Access_Key_Secret, substring, originalFilename, inputStream);

            UploadVideoImpl uploadVideo = new UploadVideoImpl();
            UploadStreamResponse uploadStreamResponse = uploadVideo.uploadStream(request);
            String videoId=null;

            if (uploadStreamResponse.isSuccess()){
                videoId = uploadStreamResponse.getVideoId();
            }else {
                videoId = uploadStreamResponse.getVideoId();
            }
            return videoId;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

//

    }
}
