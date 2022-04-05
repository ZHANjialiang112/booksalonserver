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

    public AjaxResult queryUser(String userEmail) {
        UserInfo userInfo = userInfoMapper.queryUserByEmail(userEmail);
        if (userInfo == null) {
            return AjaxResult.error("用户不存在");
        }
        return AjaxResult.success(userInfo);
    }

    public Boolean userIsExist() {
        return true;
    }
}
