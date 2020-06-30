package com.xuegao.official_account.model.dto;

/**
 * <br/> @PackageName：com.xuegao.official_account.model.dto
 * <br/> @ClassName：TextMessageDTO
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/30 14:40
 */
public class TextMessageDTO extends BaseMessageDTO {

    private String Content;

    public TextMessageDTO() {
    }

    public TextMessageDTO(String toUserName, String fromUserName, Long createTime, String msgType, Long msgId, String content) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}