package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.entity.BookInfo;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import com.zjl.booksalon.mapper.BookInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: ZJL
 * @Date: 2022/4/1 20:29
 * @Description:
 */
@Service
public class BookService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    public PageInfo<BookInfoWithBLOBs> getBookPage(BookInfo bookInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //List<BookInfoWithBLOBs> bookInfos = bookInfoMapper.queryBookPage(bookInfo);
        //PageInfo<BookInfoWithBLOBs> pageInfo = new PageInfo<>(bookInfos);
        //return pageInfo;
        return new PageInfo<>(bookInfoMapper.queryBookPage(bookInfo));
    }
}
