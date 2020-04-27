package com.gyxmb.qywx.util.xml;

import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理处理
 */
public class CDataHandler implements InvocationHandler {

    private XMLStreamWriter writer;

    public CDataHandler(XMLStreamWriter writer) {
        this.writer = writer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method gWriteCharactersMethod = null;
        try {
            gWriteCharactersMethod = XMLStreamWriter.class.getDeclaredMethod("writeCharacters", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (gWriteCharactersMethod.equals(method)) {
            String text = (String) args[0];
            if (text != null && text.startsWith("<![CDATA[") && text.endsWith("]]>")) {
                writer.writeCData(text.substring(9, text.length() - 3));
                return null;
            }
        }
        return method.invoke(writer, args);
    }

}
