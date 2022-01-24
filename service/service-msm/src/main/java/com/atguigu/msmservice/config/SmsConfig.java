package com.atguigu.msmservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SmsConfig {

    public static final String secretId="AKIDufCTVLvGOHvJRL1YruhEVWHl0ziBNJzQ";

    public static final String secretKey="FEyVpumOeeOs63kAKEsGNEp9E3cwznLd";

    public static final String appId="1400627569";



    public static final String smsSign="我的公立校个人公众号";

    public static final String templateId="1288831";



}
