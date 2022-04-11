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

    //更改用户的收藏文章数量
    int updateUserCollectNum(int userId, int count);

    //更改用户的发布文章数量
    int updateUserArticleNum(String userEmail, int count);

}