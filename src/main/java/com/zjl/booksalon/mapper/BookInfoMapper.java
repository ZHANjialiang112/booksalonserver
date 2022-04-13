package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insertNewBook(BookInfoWithBLOBs record);

    BookInfoWithBLOBs selectByPrimaryKey(Integer bookId);

    int updateBookInfoById(BookInfoWithBLOBs record);

    int updateBookCollCount(@Param("bookId") Integer bookId, @Param("count") Integer count);

    int updateBookCommCount(@Param("bookId") Integer bookId, @Param("count") Integer count);


    List<BookInfoWithBLOBs> queryBookPage(@Param("search") String search);

    List<BookInfoWithBLOBs> queryHotBookPage(@Param("search") String search);

    List<BookInfoWithBLOBs> queryUserCollBook(@Param("collUserId") int collUserId);

    List<BookInfoWithBLOBs> queryUserAllBook(@Param("userEmail") String userEmail);
}