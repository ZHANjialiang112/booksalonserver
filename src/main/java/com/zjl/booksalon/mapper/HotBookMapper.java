package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.HotBook;

public interface HotBookMapper {
    int insert(HotBook record);

    int insertSelective(HotBook record);
}