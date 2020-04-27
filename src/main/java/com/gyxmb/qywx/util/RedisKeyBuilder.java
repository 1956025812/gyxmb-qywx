package com.gyxmb.qywx.util;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 16:03
 * @ Description : REDIS的KEY构造工具类
 */
public class RedisKeyBuilder {

    /**
     * 通讯录的ACCESSTOKEN
     */
    private static final String ACCESS_TOKEN_TXL = "qywx:gyxmb:accesstoken:txl";


    /**
     * 客户联系的ACCESSTOKEN
     */
    private static final String ACCESS_TOKEN_KHLX = "qywx:gyxmb:accesstoken:khlx";


    /**
     * 应用靠近的ACCESSTOKEN
     */
    private static final String ACCESS_TOKEN_APP_KAOJIN = "qywx:gyxmb:accesstoken:kaojin";


    public static String getAccessTokenTxl() {
        return ACCESS_TOKEN_TXL;
    }

    public static String getAccessTokenKhlx() {
        return ACCESS_TOKEN_KHLX;
    }

    public static String getAccessTokenAppKaojin() {
        return ACCESS_TOKEN_APP_KAOJIN;
    }
}
