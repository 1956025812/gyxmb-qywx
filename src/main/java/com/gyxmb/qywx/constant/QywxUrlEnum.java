package com.gyxmb.qywx.constant;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 14:44
 * @ description: 企业微信URL枚举
 */
public enum QywxUrlEnum {

    /**
     * 获取ACCESS_TOKEN
     */
    GET_ACCESS_TOKEN("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s", "获取ACCESS_TOKEN"),

    /**
     * 获取部门及其子部门列表， id:部门ID
     */
    GET_DEPARTMENT_LIST("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s&id=%s", "获取部门及其子部门列表"),
    ;

    private String key;
    private String value;

    QywxUrlEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
