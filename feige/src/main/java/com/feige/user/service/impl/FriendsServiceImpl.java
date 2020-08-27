package com.feige.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feige.user.entity.Friends;
import com.feige.user.entity.Group;
import com.feige.user.entity.User;
import com.feige.user.mapper.FriendsMapper;
import com.feige.user.service.FriendsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
@Qualifier(value = "FriendService")
public class FriendsServiceImpl extends ServiceImpl<FriendsMapper, Friends> implements FriendsService {

    @Override
    public List<Friends> getUserFriends(String userId) {
        QueryWrapper<Friends> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        return baseMapper.selectList(queryWrapper);
    }
}
