package com.zjl.booksalon.service;

import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.UserinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wenman
 */
@Service
public class UserInfoService {

    @Resource
    private UserinfoMapper userinfoMapper;

    public List<UserInfo> queryAllUserList() {
        List<UserInfo> userInfos = userinfoMapper.queryAllUser();
        return userInfos;
    }

    public Boolean userIsExist() {
        return true;
    }
}
