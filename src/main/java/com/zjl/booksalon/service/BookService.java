package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.entity.BookCollect;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.mapper.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private BookCommentMapper bookCommentMapper;
    @Resource
    private HotBookMapper hotBookMapper;


    /**
     * 查询推荐页书籍信息用户是否已经收藏
     */
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

    /**
     * 查询hot页书籍信息用户是否已经收藏
     */
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

    //个人首页展示自己所有的书籍
    public PageInfo<BookInfoWithBLOBs> getUserAllBook(String userEmail, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserInfo userInfo = userInfoMapper.queryUserByEmail(userEmail);
        List<BookInfoWithBLOBs> bookInfoWithBLOBs = bookInfoMapper.queryUserAllBook(userEmail);
        for (BookInfoWithBLOBs bookInfoWithBLOB : bookInfoWithBLOBs) {
            BookCollect bookCollect = new BookCollect();
            bookCollect.setCollUserId(userInfo.getUserId());
            bookCollect.setBctBookId(bookInfoWithBLOB.getBookId());
            if (bookCollectMapper.queryCollectStatus(bookCollect) > 0) {
                bookInfoWithBLOB.setCurrUserCollect("1");
            }
        }
        return new PageInfo<>(bookInfoWithBLOBs);
    }

    //用户添加书籍
    @Transactional
    public AjaxResult userAddNewBook(BookInfoWithBLOBs bookInfoWithBLOBs) {
        userInfoMapper.updateUserArticleNum(bookInfoWithBLOBs.getUserEmail(), StringUtils.USER_ADD);
        bookInfoMapper.insertNewBook(bookInfoWithBLOBs);
        return AjaxResult.success("添加文章成功");
    }

    //更新书籍信息
    public AjaxResult userUpdateBook(BookInfoWithBLOBs bookInfoWithBLOBs) {
        bookInfoMapper.updateBookInfoById(bookInfoWithBLOBs);
        return AjaxResult.success("更新文章成功");
    }

    //删除书籍
    @Transactional
    public AjaxResult userDeleteBook(int bookId, String userEmail) {
        userInfoMapper.updateUserArticleNum(userEmail, StringUtils.USER_SUB);
        bookCommentMapper.deleteCommentById(bookId);
        hotBookMapper.deleteByHtBookId(bookId);
        List<Integer> integers = bookCollectMapper.queryAllUserIdList(bookId);
        if (integers.size() > 0) {
            for (Integer integer : integers) {
                userInfoMapper.updateUserCollectNum(integer, StringUtils.USER_SUB);
            }
        }
        BookCollect bookCollect = new BookCollect();
        bookCollect.setBctBookId(bookId);
        bookCollectMapper.deleteCollect(bookCollect);
        bookInfoMapper.deleteByPrimaryKey(bookId);
        return AjaxResult.success("删除文章成功");
    }

}
