package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSSClient;
import com.atguigu.oss.service.FileService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
//    获取阿里云的相关配置
    private String EndPoint= "oss-cn-beijing.aliyuncs.com";
    private String KeyId= "LTAI5tM4PPG46dJ7p7r5nNYA";
    private String KeySecret="tOoY3HOiG0asNZI3NDJWBNWrlQjB7T";
    private String BucketName="guli-file-inno";

    @Override
    public String upload(MultipartFile file) {
        String uploadUrl=null;
//        实例化
        OSSClient ossClient = new OSSClient(EndPoint, KeyId, KeySecret);
//        在文件名称里面增加随机唯一的值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        获取文件名称
        String originalFilename = file.getOriginalFilename();
        originalFilename=originalFilename+uuid;
//        获取文件的二进制流
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(BucketName,originalFilename,inputStream);
            ossClient.shutdown();
            uploadUrl="https://"+BucketName+"."+EndPoint+"/"+originalFilename;
            return  uploadUrl;


        } catch (IOException e) {
            e.printStackTrace();
        }


        return uploadUrl;
    }
}
