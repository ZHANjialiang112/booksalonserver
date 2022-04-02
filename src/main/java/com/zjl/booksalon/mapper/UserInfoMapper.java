package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insertUserInfo(UserInfo record);

    List<UserInfo> queryAllUser();

    UserInfo selectByUserEmail(String userEmail);

    int updateByUserEmail(UserInfo record);

}