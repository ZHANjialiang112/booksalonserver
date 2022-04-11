package com.zjl.booksalon.service;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wenman
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    //查询用户信息
    public AjaxResult queryUser(String userEmail) {
        UserInfo userInfo = userInfoMapper.queryUserByEmail(userEmail);
        if (userInfo == null) {
            return AjaxResult.error("用户不存在");
        }
        return AjaxResult.success(userInfo);
    }

    //用户修改头像背景和昵称
    public AjaxResult updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByUserEmail(userInfo) > 0 ? AjaxResult.success("修改成功") : AjaxResult.error("修改失败");
    }
}
