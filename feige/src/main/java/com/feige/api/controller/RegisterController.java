package com.feige.api.controller;

import com.feige.api.entity.RegisterResult;
import com.feige.user.entity.User;
import com.feige.user.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 注册
 *
 */
@Controller
public class RegisterController {

    @Resource
    @Qualifier(value = "userService")
    private UserService userService;

    /**
     * 用户注册
     *
     * @param email    邮箱
     * @param password 密码
     * @param phone    手机
     * @return 结果
     */
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public RegisterResult register(String email, String password, String phone) {
        RegisterResult registerResult = new RegisterResult();
        if (userService.getByLoginPhone(phone) != null) {
            registerResult.setResultCode(RegisterResult.ERROR);
            registerResult.setMessage("手机号码重复");
        } else {
            try {
                User user = new User();
                String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(password.trim());
                user.setuPwd(finalSecret);
                user.setuName(phone);
                user.setuPhone(phone);
                user.setuEmail(email);
                user.setAvatar("/img/default-user.png");
                userService.registerUser(user);
                registerResult.setResultCode(RegisterResult.SUCCESS);
                registerResult.setMessage("SUCCESS");
            } catch (Exception e) {
                registerResult.setResultCode(RegisterResult.ERROR);
                registerResult.setMessage("保存用户失败");
            }
        }
        return registerResult;
    }
}
