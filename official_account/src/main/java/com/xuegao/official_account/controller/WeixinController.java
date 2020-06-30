package com.xuegao.official_account.controller;

import com.xuegao.official_account.constant.consist.Constant;
import com.xuegao.official_account.service.WeixinMessageDispatcher;
import com.xuegao.official_account.utils.weixinUtil.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <br/> @PackageName：com.xuegao.official_account.controller
 * <br/> @ClassName：WeixinController
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/30 11:02
 */
@RestController(value = "/weixin")
public class WeixinController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    // 1
    //
    // @RequestMapping(path = "/verify_wx_token", method = RequestMethod.POST)
    // public void login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    //     log.info("=================" + "verify_wx_token" + "==============");
    //     System.out.println("=============1111");
    //     request.getParameterMap().entrySet().forEach(new Consumer<Map.Entry<String, String[]>>() {
    //         @Override
    //         public void accept(Map.Entry<String, String[]> stringEntry) {
    //             System.out.println(stringEntry.getKey() + "===" + Arrays.toString(stringEntry.getValue()));
    //         }
    //     });
    //     System.out.println("=============2222");
    //     request.setCharacterEncoding("UTF-8");
    //     String signature = request.getParameter("signature");
    //     System.out.println("signature = " + signature);
    //     String timestamp = request.getParameter("timestamp");
    //     System.out.println("timestamp = " + timestamp);
    //     String nonce = request.getParameter("nonce");
    //     System.out.println("nonce = " + nonce);
    //     String echostr = request.getParameter("echostr");
    //     System.out.println("echostr = " + echostr);
    //     System.out.println("===============3333");
    //     PrintWriter printWriter = null;
    //     try {
    //         printWriter = response.getWriter();
    //         if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
    //             printWriter.write(echostr);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (printWriter != null) {
    //             printWriter.close();
    //         }
    //     }
    // }

    // 2
    //
    // @RequestMapping(path = "/verify_wx_token", method = RequestMethod.POST)
    // public void login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    //     log.info("=================" + "verify_wx_token" + "==============");
    //     // System.out.println("=============1111");
    //     // request.getParameterMap().entrySet().forEach(new Consumer<Map.Entry<String, String[]>>() {
    //     //     @Override
    //     //     public void accept(Map.Entry<String, String[]> stringEntry) {
    //     //         System.out.println(stringEntry.getKey() + "===" + Arrays.toString(stringEntry.getValue()));
    //     // signature===[24f0c8045f2efe77e74273bfa25e477dbce0672d]
    //     // timestamp===[1593497995]
    //     // nonce===[1514793274]
    //     // openid===[oDnG-wtNbJN1ycavfv_w55MvWt2M]
    //     //     }
    //     // });
    //     // System.out.println("=============2222");
    //     request.setCharacterEncoding("UTF-8");
    //     response.setCharacterEncoding("UTF-8");
    //     PrintWriter printWriter = null;
    //     try {
    //         printWriter = response.getWriter();
    //         Map<String, String> parseXml = MessageUtil.parseXml(request);
    //         parseXml.entrySet().forEach(new Consumer<Map.Entry<String, String>>() {
    //             @Override
    //             public void accept(Map.Entry<String, String> stringStringEntry) {
    //                 System.out.println(stringStringEntry.getKey() + "===" + stringStringEntry.getValue());
    //             }
    //         });
    //         System.out.println("===========================1111");
    //         String msgType = parseXml.get("MsgType");
    //         System.out.println(msgType);
    //         String content = parseXml.get("Content");
    //         System.out.println(content);
    //         String fromusername = parseXml.get("FromUserName");
    //         System.out.println(fromusername);
    //         String tousername = parseXml.get("ToUserName");
    //         System.out.println(tousername);
    //         if("雪糕牛逼".equals(content)){
    //             if (printWriter != null) {
    //                 printWriter.println("烧肉牛逼");
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (printWriter != null) {
    //             printWriter.close();
    //         }
    //     }
    // }

    // @Autowired
    // private WeixinMessageDispatcher weixinMessageDispatcher;

    @RequestMapping(path = "/verify_wx_token", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        log.info("=================" + "verify_wx_token" + "==============");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> parseXmlMap = MessageUtil.parseXml(request);
        parseXmlMap.entrySet().forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry.getKey() + "===" + stringStringEntry.getValue());
            }
        });
        String msgType = parseXmlMap.get("MsgType");

        // 请求消息类型：推送
        if (Constant.weixinMessage.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
            String s = WeixinMessageDispatcher.processEvent(parseXmlMap);
            System.out.println("WeixinMessageDispatcher.processEvent(parseXmlMap)");
            System.out.println(s);
            return s;
        } else {
            String s = WeixinMessageDispatcher.processMessage(parseXmlMap);
            System.out.println("WeixinMessageDispatcher.processMessage(parseXmlMap)");
            System.out.println(s);
            return s;
        }

    }
}