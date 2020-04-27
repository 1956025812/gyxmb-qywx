package com.gyxmb.qywx.vo.qywxapi;

import com.gyxmb.qywx.util.xml.CDataAdapter;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * @Description 企业客户变更事件回调对象
 * @Author: duxuebo
 * @Date: 2020/3/16 11:23
 * @Version V1.0
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
@XmlType(propOrder = {
        "ToUserName",
        "FromUserName",
        "CreateTime",
        "MsgType",
        "Event",
        "ChangeType",
        "UserID",
        "ExternalUserID",
        "State",
        "WelcomeCode"
})
public class ChangeExternalContactApiVO implements Serializable {

    private static final long serialVersionUID = -5498804447890972188L;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String ToUserName;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String FromUserName;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String CreateTime;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String MsgType;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String Event;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String ChangeType;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String UserID;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String ExternalUserID;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String State;

    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String WelcomeCode;

    public ChangeExternalContactApiVO() {
    }

    public ChangeExternalContactApiVO(String toUserName, String fromUserName, String createTime, String msgType, String event, String changeType, String userID, String externalUserID, String state, String welcomeCode) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Event = event;
        ChangeType = changeType;
        UserID = userID;
        ExternalUserID = externalUserID;
        State = state;
        WelcomeCode = welcomeCode;
    }


}
