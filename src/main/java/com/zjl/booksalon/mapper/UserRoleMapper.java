package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}