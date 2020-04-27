package com.gyxmb.qywx.util.xml;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Proxy;


/**
 * @Description Jaxb工具类 xml和java类相互转换
 * @Author: duxuebo
 * @Date: 2020/3/13 16:59
 * @Version V1.0
 */
@Slf4j
public class JaxbXmlUtil {

    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * pojo转换成xml 默认编码UTF-8
     *
     * @param obj 待转化的对象
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String pojo2xml(Object obj) throws Exception {
        return pojo2xml(obj, DEFAULT_ENCODING);
    }


    /**
     * pojo转换成xml
     *
     * @param obj      待转化的对象
     * @param encoding 编码
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String pojo2xml(Object obj, String encoding) throws Exception {
        String result = null;

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        // 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

        try (StringWriter writer = new StringWriter();) {
            XMLStreamWriter streamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(writer);
            XMLStreamWriter cdataStreamWriter = (XMLStreamWriter) Proxy.newProxyInstance(
                    streamWriter.getClass().getClassLoader(),
                    streamWriter.getClass().getInterfaces(),
                    new CDataHandler(streamWriter)
            );
            marshaller.marshal(obj, cdataStreamWriter);
            result = formatXml(writer.toString());
        } catch (Exception e) {
            log.error("读取数据失败", e);
        }

        return result;
    }


    /**
     * xml转换成pojo
     *
     * @param xml xml格式字符串
     * @param t   待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xml2pojo(String xml, Class<T> t) throws Exception {
        T obj;
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try (StringReader stringReader = new StringReader(xml)) {
            obj = (T) unmarshaller.unmarshal(stringReader);
        }
        return obj;
    }


    /**
     * xml文本对齐
     */
    private static String formatXml(String xml) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            // 打开对齐开关
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // 忽略掉xml声明头信息
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter formattedStringWriter = new StringWriter();
            transformer.transform(new StreamSource(new StringReader(xml)),
                    new StreamResult(formattedStringWriter));

            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + formattedStringWriter.toString();
        } catch (TransformerException e) {
        }
        return null;
    }

}























