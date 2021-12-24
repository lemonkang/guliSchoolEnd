package com.atguigu.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private  String keySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;
    public  static String EndPoint;
    public  static String KeyId;
    public  static String KeySecret;
    public  static String BucketName;

    @Override
    public void afterPropertiesSet() throws Exception {
        EndPoint=endpoint;
        KeyId=keyId;
        KeySecret=keySecret;
        BucketName=bucketName;
    }
}
