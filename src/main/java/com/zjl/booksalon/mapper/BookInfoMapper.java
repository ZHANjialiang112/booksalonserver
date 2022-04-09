package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookInfo;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insertNewBook(BookInfoWithBLOBs record);

    BookInfoWithBLOBs selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfoWithBLOBs record);

    int updateBookCommCount(BookInfo bookInfo);

    List<BookInfoWithBLOBs> queryBookPage(@Param("search") String search);

    List<BookInfoWithBLOBs> queryHotBookPage(@Param("search") String search);

}