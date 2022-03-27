package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.service.LoginService;
import com.zjl.booksalon.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/alluser")
    public AjaxResult queryAllUserList() {
        List<UserInfo> userInfos = userInfoService.queryAllUserList();
        return AjaxResult.success("请求成功", userInfos);
    }

    //用户登录接口
    @CrossOrigin
    @PostMapping("/login")
    public AjaxResult login(@RequestBody UserInfo userInfo) {
        return loginService.login(userInfo);
    }

    //用户注册、修改账号密码操作获取对应验证码
    @CrossOrigin
    @PostMapping("/getRegisterCode")
    public AjaxResult register(@RequestBody UserInfo userInfo) {
        return loginService.getRegisterCode(userInfo);
    }

    //验证用户注册，修改密码验证码是否正确，并进行数据库的持久化操作
    @CrossOrigin
    @PostMapping("/updateAndRegister")
    public AjaxResult updateUserInfo(@RequestBody UserInfo userInfo, @RequestParam("authCod") String authCode) {
        return loginService.registerAndUpdate(userInfo, authCode);
    }

}
