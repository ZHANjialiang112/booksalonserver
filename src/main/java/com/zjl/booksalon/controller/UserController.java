package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.service.LoginService;
import com.zjl.booksalon.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/updateInfo")
    public AjaxResult updateUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }


}
