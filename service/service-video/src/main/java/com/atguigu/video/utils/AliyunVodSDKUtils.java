package com.atguigu.video.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;

public class AliyunVodSDKUtils {

//    初始化
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException {
        String regionId = "cn-shanghai";  // 点播服务接入地域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
//    根据视频i删除视频的响应
    public static DeleteVideoResponse infoVideo(DefaultAcsClient client, String id) throws Exception {
    DeleteVideoRequest request = new DeleteVideoRequest();
    //支持传入多个视频ID，多个用逗号分隔
    request.setVideoIds(id);
    return client.getAcsResponse(request);
}
    //    根据视频id返回这个视频的响应
    public static GetVideoInfoResponse getVideoInfo(DefaultAcsClient client,String id) throws Exception {
        GetVideoInfoRequest request = new GetVideoInfoRequest();
        request.setVideoId(id);
        return client.getAcsResponse(request);
    }
    /*获取播放地址函数*/
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client,String id) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(id);
        return client.getAcsResponse(request);
    }
    /*获取播放凭证函数*/
    public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client,String id) throws Exception {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(id);
        return client.getAcsResponse(request);
    }
}
