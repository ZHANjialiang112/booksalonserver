package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.entity.BookComment;
import com.zjl.booksalon.mapper.BookCommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: ZJL
 * @Date: 2022/4/5 23:18
 * @Description:
 */
@Service
public class BookCommService {
    @Resource
    private BookCommentMapper bookCommentMapper;

    public PageInfo<BookComment> getBookAllcomm(String bookName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookComment> commentList = bookCommentMapper.selectCommByBkName(bookName);
        return new PageInfo<>(commentList);
    }


}
