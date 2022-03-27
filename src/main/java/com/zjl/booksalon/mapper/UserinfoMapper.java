package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> queryAllUser();

    UserInfo queryUserByeMail(@Param("eMail") String eMail);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}