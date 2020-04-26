package com.gyxmb.qywx.util;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 16:03
 * @ Description : REDIS的KEY构造工具类
 */
public class RedisKeyBuilder {

    /**
     * 靠近应用的ACCESSTOKEN
     */
    private static final String ACCESS_TOKEN_KAOJIN = "qywx:gyxmb:accesstoken:kaojin";


    public static String getAccessTokenKaojin() {
        return ACCESS_TOKEN_KAOJIN;
    }
}
