package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.service.LoginService;
import com.zjl.booksalon.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2022/3/27 11:44
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/getUser")
    public AjaxResult queryUser(@RequestParam("userEmail") String userEmail) {
        return userInfoService.queryUser(userEmail);
    }

    //用户登录接口
    @PostMapping("/login")
    public AjaxResult login(@RequestBody UserInfo userInfo) {
        return loginService.login(userInfo);
    }

    //用户注册、修改账号密码操作获取对应验证码
    @PostMapping("/getRegisterCode")
    public AjaxResult register(@RequestBody UserInfo userInfo, @RequestParam("titleType") String titleType) {
        return loginService.getRegisterCode(userInfo, titleType);
    }

    //验证用户注册，修改密码验证码是否正确，并进行数据库的持久化操作
    @PostMapping("/updateAndRegister")
    public AjaxResult updateUserInfo(@RequestBody UserInfo userInfo, @RequestParam("authCod") String authCode,
                                     @RequestParam("titleType") String titleType) {
        return loginService.registerAndUpdate(userInfo, authCode, titleType);
    }

}
