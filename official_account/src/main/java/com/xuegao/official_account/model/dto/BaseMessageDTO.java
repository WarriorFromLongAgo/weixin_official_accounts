package com.xuegao.official_account.model.dto;

/**
 * <br/> @PackageName：com.xuegao.official_account.model.dto
 * <br/> @ClassName：BaseMessageDTO
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/30 14:39
 */
public class BaseMessageDTO {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private Long MsgId;

    // ToUserName 表示开发者的微信号
    // FromUserName 表示发送方账号（用户的 OpenID）
    // CreateTime 消息的创建时间
    // MsgType 表示消息的类型
    // MsgId 表示消息 id

    public BaseMessageDTO() {
    }

    public BaseMessageDTO(String toUserName, String fromUserName, Long createTime, String msgType, Long msgId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}