package com.gyxmb.qywx.vo.qywxapi;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 15:24
 * @ Description : ACCESS_TOKEN的VO对象
 */
@Data
public class AccessTokenApiVO implements Serializable {

    private static final long serialVersionUID = -6106902060314556072L;

    private Integer errcode;
    private String errmsg;
    private String AccessToken;

    public AccessTokenApiVO() {
    }

    public AccessTokenApiVO(Integer errcode, String errmsg, String accessToken) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        AccessToken = accessToken;
    }
}
