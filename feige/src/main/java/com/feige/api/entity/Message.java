package com.feige.api.entity;

import lombok.Data;

/**
 * websocket 通讯的json
 */
@Data
public class Message {

    /**
     * 消息来源用户名
     */
    private String username;

    /**
     * 发送者头像
     */
    private String avatar;

    /**
     * 消息的来源ID（如果是私聊，则是用户id，如果是群聊，则是群组id）
     */
    private String id;

    /**
     * 消息类型 friend
     */
    private String type;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息id
     */
    private String cid;

    /**
     * 是否本人发送
     */
    private boolean mine;

    /**
     * 消息的发送者id
     */
    private String fromid;

    /**
     * 服务端时间戳毫秒数
     */
    private long timestamp;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
