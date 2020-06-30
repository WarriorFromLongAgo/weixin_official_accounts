package com.xuegao.official_account.service;

import com.xuegao.official_account.constant.consist.Constant;
import com.xuegao.official_account.model.dto.TextMessageDTO;
import com.xuegao.official_account.utils.weixinUtil.MessageUtil;

import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.official_account.service
 * <br/> @ClassName：WeixinMessageDispatcher
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/30 14:51
 */
// @Service
public class WeixinMessageDispatcher {
    public static String processMessage(Map<String, String> map) {
        //用户 openid
        String openid = map.get("FromUserName");
        //公众号原始 ID
        String mpid = map.get("ToUserName");
        if (map.get("MsgType").equals(Constant.weixinMessage.REQ_MESSAGE_TYPE_TEXT)) {
            //普通文本消息
            TextMessageDTO textMessageDTO = new TextMessageDTO();
            textMessageDTO.setToUserName(openid);
            textMessageDTO.setFromUserName(mpid);
            textMessageDTO.setCreateTime(System.currentTimeMillis());
            textMessageDTO.setMsgType(Constant.weixinMessage.RESP_MESSAGE_TYPE_TEXT);
            textMessageDTO.setContent("烧肉牛逼");
            return MessageUtil.textMessageToXml(textMessageDTO);
        }
        return null;
    }

    public static String processEvent(Map<String, String> map) {
        //在这里处理事件
        return "processEvent = 在这里处理事件";
    }
}