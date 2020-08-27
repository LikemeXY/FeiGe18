package com.feige.user.service.impl;

import com.feige.user.entity.Login;
import com.feige.user.mapper.LoginMapper;
import com.feige.user.service.LoginService;
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
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

}
