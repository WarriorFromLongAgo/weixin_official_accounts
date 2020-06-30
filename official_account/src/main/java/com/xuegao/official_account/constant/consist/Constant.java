package com.xuegao.official_account.constant.consist;

/**
 * @PackageName：com.fff.springbooto.constant
 * @ClassName：
 * @Description：
 * @author：
 * @date：2020/1/10 15:50
 */
public class Constant {

    public interface RedisConstant {

        String OK = "OK";
        // 过期时间, 60s, 一分钟
        Integer EXPIRE_TIME_MINUTE = 60;
        // 过期时间, 600s, 十分钟
        Integer EXPIRE_TIME_TEN_MINUTE = 60 * 10;
        // 过期时间, 一小时
        Integer EXPIRE_TIME_HOUR = 60 * 60;
        // 过期时间, 半天
        Integer EXPIRE_TIME_HALF_DAY = 60 * 60 * 12;
        // 过期时间, 一天
        Integer EXPIRE_TIME_DAY = 60 * 60 * 24;
        // token 头
        String TOKEN_PREFIX = "token:";
        // 消息消费者前缀
        String MESSAGE_CONSUMER_PREFIX = "consumer:";
        // 访问限制前缀
        String ACCESS_LIMIT_PREFIX = "accessLimit:";
    }

    public interface LogType {
        // 登录
        Integer LOGIN = 1;
        // 登出
        Integer LOGOUT = 2;
    }

    public interface MessageLogStatus {
        // 消息投递中
        Integer DELIVERING = 0;
        // 投递成功
        Integer DELIVER_SUCCESS = 1;
        // 投递失败
        Integer DELIVER_FAIL = 2;
        // 已消费
        Integer CONSUMED_SUCCESS = 3;
    }

    public interface weixinMessage {
        /**
         * 返回消息类型：文本
         */
        String RESP_MESSAGE_TYPE_TEXT = "text";
        /**
         * 返回消息类型：音乐
         */
        String RESP_MESSAGE_TYPE_MUSIC = "music";
        /**
         * 返回消息类型：图文
         */
        String RESP_MESSAGE_TYPE_NEWS = "news";
        /**
         * 返回消息类型：图片
         */
        String RESP_MESSAGE_TYPE_IMAGE = "image";
        /**
         * 返回消息类型：语音
         */
        String RESP_MESSAGE_TYPE_VOICE = "voice";
        /**
         * 返回消息类型：视频
         */
        String RESP_MESSAGE_TYPE_VIDEO = "video";
        /**
         * 请求消息类型：文本
         */
        String REQ_MESSAGE_TYPE_TEXT = "text";
        /**
         * 请求消息类型：图片
         */
        String REQ_MESSAGE_TYPE_IMAGE = "image";
        /**
         * 请求消息类型：链接
         */
        String REQ_MESSAGE_TYPE_LINK = "link";
        /**
         * 请求消息类型：地理位置
         */
        String REQ_MESSAGE_TYPE_LOCATION = "location";
        /**
         * 请求消息类型：音频
         */
        String REQ_MESSAGE_TYPE_VOICE = "voice";
        /**
         * 请求消息类型：视频
         */
        String REQ_MESSAGE_TYPE_VIDEO = "video";
        /**
         * 请求消息类型：推送
         */
        String REQ_MESSAGE_TYPE_EVENT = "event";
        /**
         * 事件类型：subscribe(订阅)
         */
        String EVENT_TYPE_SUBSCRIBE = "subscribe";
        /**
         * 事件类型：unsubscribe(取消订阅)
         */
        String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
        /**
         * 事件类型：CLICK(自定义菜单点击事件)
         */
        String EVENT_TYPE_CLICK = "CLICK";
        /**
         * 事件类型：VIEW(自定义菜单 URl 视图)
         */
        String EVENT_TYPE_VIEW = "VIEW";
        /**
         * 事件类型：LOCATION(上报地理位置事件)
         */
        String EVENT_TYPE_LOCATION = "LOCATION";
        /**
         * 事件类型：LOCATION(上报地理位置事件)
         */
        String EVENT_TYPE_SCAN = "SCAN";
    }
}
