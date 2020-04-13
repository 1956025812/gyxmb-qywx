package com.gyxmb.qywx.util;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 16:03
 * @ Description : REDIS的KEY构造工具类
 */
public class RedisKeyBuilder {

    /**
     * 遇见应用的ACCESSTOKEN
     */
    private static final String ACCESS_TOKEN_YUJIAN = "qywx:gyxmb:accesstoken:yujian";


    public static String getAccessTokenYujian() {
        return ACCESS_TOKEN_YUJIAN;
    }
}
