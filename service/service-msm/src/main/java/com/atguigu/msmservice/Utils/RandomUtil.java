package com.atguigu.msmservice.Utils;

import com.atguigu.msmservice.config.SmsConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    private static final DecimalFormat fourdf = new DecimalFormat("0000");

    private static final DecimalFormat sixdf = new DecimalFormat("000000");

    public static String getFourBitRandom() {

        return fourdf.format(random.nextInt(10000));

    }

    public static String getSixBitRandom() {
        return sixdf.format(random.nextInt(1000000));
    }


}
