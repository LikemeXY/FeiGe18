package com.feige.user.mapper;

import com.feige.user.entity.Group;
import com.feige.user.entity.Grouptable;
import com.feige.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户id 获取好友的分组
     * @param userId id
     * @return List<Group>
     */
    List<Group> getGroupUsers(String userId);

    /**
     * 根据用户id 获取群组
     * @param userId id
     * @return List<ImGroup>
     */
    List<Grouptable> getUserGroups(String userId);


    /**
     * 获取群组的用户
     * @param chatId 群组id
     * @return 用户List
     */
    List<User> getChatUserList(String chatId);

}
