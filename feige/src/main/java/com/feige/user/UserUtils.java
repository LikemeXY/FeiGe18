package com.feige.user;

import com.feige.common.SpringContextHolder;
import com.feige.user.entity.User;
import com.feige.user.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {

    private static UserService userService = SpringContextHolder.getBean(UserService.class);

    /**
     * 从系统中读取用户
     *
     * @return 用户信息
     */
    public static User getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userService.getByLoginName(userDetails.getUsername());
    }
}
