package com.feige.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feige.user.entity.*;
import com.feige.user.mapper.UserMapper;
import com.feige.user.service.FriendsService;
import com.feige.user.service.GroupService;
import com.feige.user.service.UserGroupService;
import com.feige.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
@Service
@Qualifier(value = "userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Value("${fg.admin.id}")
    private String adminId;

    @Value("${fg.default.chat.id}")
    private String defaultChatId;

    @Resource
    @Qualifier(value = "groupService")
    private GroupService groupService;


    @Resource
    @Qualifier(value = "friendsService")
    private FriendsService friendsService;

    @Resource
    @Qualifier(value = "userGroupService")
    private UserGroupService userGroupService;

    @Override
    public User getByLoginPhone(String uPhone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_phone", uPhone);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public User getByLoginName(String uName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_name", uName);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Group> getGroupUsers(String uId) {

        return baseMapper.getGroupUsers(uId);
    }

    @Override
    public List<Grouptable> getChatGroups(String uId) {

        return baseMapper.getUserGroups(uId);
    }

    @Override
    public List<User> getChatUserList(String chatId) {
        return baseMapper.getChatUserList(chatId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerUser(User user) {
        try {
            save(user);
            //添加默认用户分组 我的好友
            Group group = new Group();
            group.setName("我的好友");
            group.setUserid(user.getuId());
            groupService.save(group);


            //更新默认的用户组
            user.setDefaultGroupId(group.getId());
            updateById(user);

            //保存用户好友，默认管理员
            Friends imUserFriend = new Friends();
            imUserFriend.setuId(user.getuId());
            imUserFriend.setFid(adminId);
            imUserFriend.setUserGroupId(group.getId());
            //默认好友的分组
            User friend = getById(adminId);
            imUserFriend.setFriendGroupId(friend.getDefaultGroupId());
            friendsService.save(imUserFriend);

            //添加默认群
            UserGroup imChatGroupUser = new UserGroup();
            imChatGroupUser.setuId(user.getuId());
            imChatGroupUser.setGon(defaultChatId);
            userGroupService.save(imChatGroupUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
