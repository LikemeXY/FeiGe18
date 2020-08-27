package com.feige.user.service.impl;

import com.feige.user.entity.Group;
import com.feige.user.mapper.GroupMapper;
import com.feige.user.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

}
