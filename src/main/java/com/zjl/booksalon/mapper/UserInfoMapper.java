package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insertUserInfo(UserInfo record);

    UserInfo queryUserByEmail(String userEmail);

    UserInfo selectByUserEmail(String userEmail);

    int updateByUserEmail(UserInfo record);

    int updateUserCollectNum(int userId, int count);

}