package com.feige.tio;

import org.tio.core.ChannelContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class WsOnlineContext {
    private static Map<String, ChannelContext> map = new ConcurrentHashMap<>();

    public static void bindUser(String userId, ChannelContext channelContext) {
        map.put(userId, channelContext);
    }

    public static ChannelContext getChannelContextByUser(String userId){
        return map.get(userId);
    }
}
