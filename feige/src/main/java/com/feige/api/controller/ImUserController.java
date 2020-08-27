package com.feige.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feige.api.entity.Message;
import com.feige.api.entity.SendInfo;
import com.feige.common.utils.ChatUtils;
import com.feige.message.entity.ImMessage;
import com.feige.message.service.IImMessageService;
import com.feige.tio.StartTioRunner;
import com.feige.tio.TioServerConfig;
import com.feige.tio.WsOnlineContext;
import com.feige.user.entity.User;
import com.feige.user.service.FriendsService;
import com.feige.user.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.server.ServerGroupContext;
import org.tio.websocket.common.WsResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前端控制器
 *
 */
@RestController
@RequestMapping("/api/user")
public class ImUserController {

    private final Logger logger = LoggerFactory.getLogger(ImUserController.class);

    @Resource
    private StartTioRunner startTioRunner;

    @Resource
    @Qualifier(value = "userService")
    private UserService userService;

    @Resource
    @Qualifier(value = "friendsService")
    private FriendsService friendsService;

    @Resource
    @Qualifier(value = "iImMessageService")
    private IImMessageService iImMessageService;

    /**
     * 用户信息初始化
     *
     * @param request request
     * @return json
     */
    @RequestMapping("init")
    public Map<String, Object> list(HttpServletRequest request) {
        logger.debug("init");
        Map<String, Object> objectMap = new HashMap<>();
        //获取好友信息
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.getByLoginName(username);
        objectMap.put("friends", friendsService.getUserFriends(user.getuId()));

        //获取本人信息
        String host = ChatUtils.getHost(request);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", username);
        user.setAvatar(host + user.getAvatar());
        user.setuPwd(null);
        objectMap.put("me", user);

        //用户的群组信息
        objectMap.put("groups", userService.getChatGroups(user.getuId()));
        return objectMap;
    }


    /**
     * 获取群组的用户
     *
     * @param chatId 群组id
     * @return 用户List
     */
    @RequestMapping("chatUserList")
    public List<User> chatUserList(String chatId) {
        return userService.getChatUserList(chatId);
    }

    /**
     * 发送信息给用户
     * 注意：目前仅支持发送给在线用户
     *
     * @param userId 接收方id
     * @param msg    消息内容
     */
    @PostMapping("sendMsg")
    public void sendMsg(String userId, String msg, HttpServletRequest request) throws Exception {
        String host = ChatUtils.getHost(request);
        ServerGroupContext serverGroupContext = startTioRunner.getAppStarter().getWsServerStarter().getServerGroupContext();

        SendInfo sendInfo = new SendInfo();
        sendInfo.setCode(ChatUtils.MSG_MESSAGE);
        Message message = new Message();
        message.setId("system");
        message.setFromid("system");
        message.setContent(msg);
        message.setMine(false);
        message.setTimestamp(System.currentTimeMillis());
        message.setType(ChatUtils.FRIEND);
        message.setAvatar(host + "/img/icon.png");
        message.setUsername("系统消息");
        sendInfo.setMessage(message);

        ChannelContext cc = WsOnlineContext.getChannelContextByUser(userId);
        if (cc != null && !cc.isClosed) {
            WsResponse wsResponse = WsResponse.fromText(new ObjectMapper().writeValueAsString(sendInfo), TioServerConfig.CHARSET);
            Tio.sendToUser(serverGroupContext, userId, wsResponse);
        } else {
            saveMessage(message, ChatUtils.UNREAD, userId);
        }
    }


    private void saveMessage(Message message, String readStatus, String userId) {
        ImMessage imMessage = new ImMessage();
        imMessage.setToId(userId);
        imMessage.setFromId(message.getFromid());
        imMessage.setSendTime(System.currentTimeMillis());
        imMessage.setContent(message.getContent());
        imMessage.setReadStatus(readStatus);
        imMessage.setType(message.getType());
        iImMessageService.saveMessage(imMessage);
    }
}
