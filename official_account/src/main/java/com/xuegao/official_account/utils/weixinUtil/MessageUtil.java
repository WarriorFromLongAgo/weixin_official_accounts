package com.xuegao.official_account.utils.weixinUtil;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.xuegao.official_account.model.dto.TextMessageDTO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br/> @PackageName：com.xuegao.official_account.utils
 * <br/> @ClassName：MessageUtil
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/30 14:14
 */
public class MessageUtil {
    /**
     * <br/> @Title: 解析xml
     * <br/> @MethodName:  parseXml
     * <br/> @param request:
     * <br/> @Return java.util.Map<java.lang.String,java.lang.String>
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/30 14:44
     */
    public static Map<String, String> parseXml(HttpServletRequest request) {
        Map<String, String> map = new ConcurrentHashMap<>(10);
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> elementList = rootElement.elements();
            for (Element element : elementList) {
                map.put(element.getName(), element.getText());
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /**
     * <br/> @Title: 生成指定规范的xml
     * <br/> @MethodName:  textMessageToXml
     * <br/> @param textMessageDTO:
     * <br/> @Return java.lang.String
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/30 15:03
     */
    public static String textMessageToXml(TextMessageDTO textMessageDTO) {
        xstream.alias("xml", textMessageDTO.getClass());
        return xstream.toXML(textMessageDTO);
    }

    private static XStream xstream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = true;

                @Override
                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}