package com.gyxmb.qywx.constant;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 15:13
 * @ Description : 企业微信响应码
 */
public enum QywxCodeEnum {

    /**
     * -1-系统繁忙
     */
    SYSATEM_BUSY(-1, "系统繁忙"),
    SUCCESS(0, "请求成功"),
    ERROR_SECRET(40001, "不合法的SECRET参数"),
    ERROR_USERID(40003, "无效的UserID"),
    ERROR_MEDIA_TYPE(40004, "不合法的媒体文件类型"),
    ERROR_TYPE(40005, "不合法的type参数"),
    ERROR_FILE_SIZE(40006, "不合法的文件大小"),
    ERROR_MEDIA_ID(40007, "不合法的media_id参数"),
    ERROR_MSG_TYPE(40008, "不合法的msgtype参数"),
    ERROR_IMG_SIZE(40009, "上传图片大小不是有效值"),
    ERROR_VIDEO_SIZE(40011, "上传视频大小不是有效值"),
    ERROR_CORPID(40013, "不合法的CorpID"),
    ERROR_ACCESS_TOKEN(40014, "不合法的access_token"),
    ;

    private Integer key;
    private String value;

    QywxCodeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String acquireValue(Integer key) {
        String value = null;
        for (QywxCodeEnum eachQywxCodeEnum : QywxCodeEnum.values()) {
            if (eachQywxCodeEnum.getKey().equals(key)) {
                value = eachQywxCodeEnum.getValue();
                break;
            }
        }
        return value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
