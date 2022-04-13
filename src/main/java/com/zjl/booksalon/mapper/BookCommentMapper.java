package com.zjl.booksalon.mapper;

import com.zjl.booksalon.entity.BookComment;

import java.util.List;

public interface BookCommentMapper {
    int insert(BookComment record);

    int insertSelective(BookComment record);

    List<BookComment> selectCommByBkName(String bookName);

    int deleteCommentById(int bookId);
}