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
 * @Description 客户群变更事件回调对象
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
        "ChatId"
})
public class ChangeExternalChatApiVO implements Serializable {

    private static final long serialVersionUID = -876183231147266326L;

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
    private String ChatId;

    public ChangeExternalChatApiVO() {
    }

    public ChangeExternalChatApiVO(String toUserName, String fromUserName, String createTime, String msgType, String event, String chatId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Event = event;
        ChatId = chatId;
    }
}
