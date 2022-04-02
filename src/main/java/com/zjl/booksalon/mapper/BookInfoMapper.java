package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookInfo;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insertNewBook(BookInfoWithBLOBs record);

    BookInfoWithBLOBs selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfoWithBLOBs record);

    List<BookInfoWithBLOBs> queryBookPage(BookInfo bookInfo);

}