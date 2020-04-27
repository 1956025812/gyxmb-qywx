package com.gyxmb.qywx.vo.qywxapi;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 企业微信回调VO对象
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-27 09:40
 */
@Data
public class CallbackApiVO implements Serializable {

    private static final long serialVersionUID = -6394247136107075176L;

    private String event;
    private String changeType;
    private String callbackXml;

    public CallbackApiVO() {
    }

    public CallbackApiVO(String event, String changeType, String callbackXml) {
        this.event = event;
        this.changeType = changeType;
        this.callbackXml = callbackXml;
    }


}
