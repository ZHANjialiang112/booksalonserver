package com.zjl.booksalon.service;

import com.zjl.booksalon.entity.UserRole;
import com.zjl.booksalon.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 13:23
 * @Description:
 */
@Service
public class UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    public UserRole getUserRolePermission(String userEmail) {
        return userRoleMapper.queryUserInfoPermission(userEmail);

    }

}
