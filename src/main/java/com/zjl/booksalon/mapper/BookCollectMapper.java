package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookCollect;

public interface BookCollectMapper {
    int insert(BookCollect record);

    int insertSelective(BookCollect record);

    int queryCollectStatus(BookCollect record);

    int deleteCollect(BookCollect record);
}