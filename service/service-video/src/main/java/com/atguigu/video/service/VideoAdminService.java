package com.atguigu.video.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoAdminService {
    String uploadvideo(MultipartFile file);
}
