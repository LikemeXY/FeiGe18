package com.feige.user.service;

import com.feige.user.entity.Friends;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feige.user.entity.Group;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
public interface FriendsService extends IService<Friends> {

    /**
     * 根据用户的ID 获取 用户好友(双向用户关系)
     *
     * @param userId 用户ID
     * @return 好友分组的列表
     */
    List<Friends> getUserFriends(String userId);
}
