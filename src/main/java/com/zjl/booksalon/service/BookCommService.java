package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.entity.BookComment;
import com.zjl.booksalon.mapper.BookCommentMapper;
import com.zjl.booksalon.mapper.BookInfoMapper;
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
    @Resource
    private BookInfoMapper bookInfoMapper;


    public PageInfo<BookComment> getBookAllcomm(String bookName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookComment> commentList = bookCommentMapper.selectCommByBkName(bookName);
        return new PageInfo<>(commentList);
    }

    //添加评论
    public AjaxResult addBookComm(BookComment bookComment) {
        bookInfoMapper.updateBookCommCount(bookComment.getBookId(), StringUtils.USER_ADD);
        bookCommentMapper.insert(bookComment);
        return AjaxResult.success();
    }


}
