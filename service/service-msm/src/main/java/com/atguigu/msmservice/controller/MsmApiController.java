package com.atguigu.msmservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.msmservice.Utils.RandomUtil;
import com.atguigu.msmservice.Utils.SendSmsUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/msmservice/msm")
@CrossOrigin
public class MsmApiController {

    @GetMapping("sendPhone")
    public R sendPhone(@RequestParam(value = "phone") String phone){
        String fourBitRandom = RandomUtil.getFourBitRandom();
        SendSmsUtil sendSmsUtil = new SendSmsUtil();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",fourBitRandom);
        boolean send = sendSmsUtil.send(map, phone);

        return R.ok().data("bool",send);

    }
}
