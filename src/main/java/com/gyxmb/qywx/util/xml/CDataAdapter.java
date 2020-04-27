package com.gyxmb.qywx.util.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * JAXB的CDATA转换处理类
 */
public class CDataAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return new StringBuilder("<![CDATA[").append(v).append("]]>").toString();
    }

}





