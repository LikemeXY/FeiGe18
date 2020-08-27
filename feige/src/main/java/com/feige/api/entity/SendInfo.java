package com.feige.api.entity;

import lombok.Data;

/**
 * websocket 通讯的json 封装
 */
@Data
public class SendInfo {

    /**
     * 发送信息的代码
     */
    private String code;

    /**
     * 信息
     */
    private Message message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
