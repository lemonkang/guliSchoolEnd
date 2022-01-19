package com.atguigu.video.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;
import com.atguigu.video.constant.ConstantPropertiesUtil;
import com.atguigu.video.service.VideoAdminService;
import com.atguigu.video.utils.AliyunVodSDKUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

//根据视频id删除视频   删除true  未删除false
    @Override
    public Boolean deleteVideo(String id) {
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.Access_Key_Id, ConstantPropertiesUtil.Access_Key_Secret);
            DeleteVideoResponse response = new DeleteVideoResponse();
            try {
                response = AliyunVodSDKUtils.infoVideo(client, id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String requestId = response.getRequestId();
            if (requestId==null || requestId.isEmpty()){
                return false;

            }

            System.out.println("删除的视频id"+response.getRequestId());

        } catch (ClientException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String getvideo(String id) {
        String videourl=null;
        DefaultAcsClient client = null;
        try {
            client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.Access_Key_Id, ConstantPropertiesUtil.Access_Key_Secret);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        try {
            response = AliyunVodSDKUtils.getPlayInfo(client,id);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            //播放地址
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
                videourl= playInfo.getPlayURL();
            }
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return videourl;
    }
//    根据id获取视频的播放凭证
    @Override
    public String getVideoPlayAuth(String videoid) {
        String auth=null;
        DefaultAcsClient client = null;
        try {
            client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.Access_Key_Id, ConstantPropertiesUtil.Access_Key_Secret);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        try {
            response = AliyunVodSDKUtils.getVideoPlayAuth(client,videoid);
            //播放凭证
            auth=response.getPlayAuth();

        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }

        return auth;
    }

}
