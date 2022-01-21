package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class VodFileDegradeFeignClient implements VodClient{
    @Override
    public R deleteVideo(String videoID) {
       return R.fail().message("请求失败熔断");
    }

    @Override
    public R deleteVideoByCourseId(ArrayList<String> sourceIdStrings) {
        return R.fail().message("请求失败熔断");
    }
}
