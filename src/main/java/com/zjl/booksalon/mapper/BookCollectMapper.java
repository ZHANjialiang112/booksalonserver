package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookCollect;

import java.util.List;

public interface BookCollectMapper {

    int insertSelective(BookCollect record);

    int queryCollectStatus(BookCollect record);

    int deleteCollect(BookCollect record);

    List<Integer> queryAllUserIdList(int bctBookId);
}