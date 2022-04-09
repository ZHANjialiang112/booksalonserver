package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.entity.BookCollect;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import com.zjl.booksalon.mapper.BookCollectMapper;
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
    @Resource
    private BookCollectMapper bookCollectMapper;

    //查询推荐页书籍信息用户是否已经收藏
    public PageInfo<BookInfoWithBLOBs> getBookPage(String search, int pageNum, int pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BookInfoWithBLOBs> bookPage = new PageInfo<>(bookInfoMapper.queryBookPage(search));
        if ("".equals(userId) || userId == null) {
            return bookPage;
        }
        //判断收藏列表中是否包含该书籍
        for (BookInfoWithBLOBs bookInfo : bookPage.getList()) {
            BookCollect bookCollect = new BookCollect();
            bookCollect.setCollUserId(Integer.parseInt(userId));
            bookCollect.setBctBookId(bookInfo.getBookId());
            if (bookCollectMapper.queryCollectStatus(bookCollect) > 0) {
                bookInfo.setCurrUserCollect("1");
            }
        }
        return bookPage;
    }

    //查询hot页书籍信息用户是否已经收藏
    public PageInfo<BookInfoWithBLOBs> getHotBookPage(String search, int pageNum, int pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BookInfoWithBLOBs> hotBookPage = new PageInfo<>(bookInfoMapper.queryHotBookPage(search));
        if ("".equals(userId) || userId == null) {
            return hotBookPage;
        }
        for (BookInfoWithBLOBs bookInfo : hotBookPage.getList()) {
            BookCollect bookCollect = new BookCollect();
            bookCollect.setCollUserId(Integer.parseInt(userId));
            bookCollect.setBctBookId(bookInfo.getBookId());
            if (bookCollectMapper.queryCollectStatus(bookCollect) > 0) {
                bookInfo.setCurrUserCollect("1");
            }
        }
        return hotBookPage;
    }
}
