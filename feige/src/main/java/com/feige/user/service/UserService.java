package com.feige.user.service;

import com.feige.user.entity.Group;
import com.feige.user.entity.Grouptable;
import com.feige.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
public interface UserService extends IService<User> {
    /**
     * 根据登录名称获取用户
     * @param uName 登录名
     * @return 用户
     */
    User getByLoginName(String uName);

    /**
     * 根据电话号码称获取用户
     * @param uPhone 登录名
     * @return 用户
     */
    User getByLoginPhone(String uPhone);

    /**
     * 获取用户分组信息
     * @param uId 用户id
     * @return ImGroup
     */
    List<Group> getGroupUsers(String uId);

    /**
     * 根据用户id 获取用户所有的群
     * @param uId 用户
     * @return 群List
     */
    List<Grouptable> getChatGroups(String uId);

    /**
     * 获取群组的用户
     * @param chatId 群组id
     * @return 用户List
     */
    List<User> getChatUserList(String chatId);


    /**
     * 注册用户
     * @param imUser 用户对象
     */
    void registerUser(User imUser);

}
