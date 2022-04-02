package com.zjl.booksalon.service;

import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wenman
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> queryAllUserList() {
        List<UserInfo> userInfos = userInfoMapper.queryAllUser();
        return userInfos;
    }

    public Boolean userIsExist() {
        return true;
    }
}
