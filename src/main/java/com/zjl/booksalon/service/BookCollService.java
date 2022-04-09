package com.zjl.booksalon.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.utils.StringUtils;
import com.zjl.booksalon.entity.BookCollect;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import com.zjl.booksalon.mapper.BookCollectMapper;
import com.zjl.booksalon.mapper.BookInfoMapper;
import com.zjl.booksalon.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: ZJL
 * @Date: 2022/4/9 16:30
 * @Description:
 */
@Service
public class BookCollService {

    @Resource
    private BookCollectMapper bookCollectMapper;
    @Resource
    private BookInfoMapper bookInfoMapper;
    @Resource
    private UserInfoMapper userInfoMapper;


    /**
     * 用户添加收藏
     *
     * @param bctBookId  书籍id
     * @param collUserId 收藏用户id
     * @param userEmail  发布书籍用户邮箱
     * @return
     */
    @Transactional
    public AjaxResult userAddCollect(int collUserId, int bctBookId, String userEmail) {
        BookCollect bookCollect = new BookCollect();
        bookCollect.setBctBookId(bctBookId);
        bookCollect.setCollUserId(collUserId);
        bookCollect.setBctUserId(userInfoMapper.queryUserByEmail(userEmail).getUserId());
        bookCollectMapper.insertSelective(bookCollect);
        bookInfoMapper.updateBookCommCount(bctBookId, StringUtils.USER_ADD_COLLECT);
        userInfoMapper.updateUserCollectNum(collUserId, StringUtils.USER_ADD_COLLECT);
        return AjaxResult.success("收藏成功");
    }

    /**
     * 用户取消收藏
     *
     * @param bctBookId  书籍id
     * @param collUserId 收藏用户id
     * @param userEmail  发布书籍用户邮箱
     */
    @Transactional
    public AjaxResult userCancelCollect(int collUserId, int bctBookId, String userEmail) {
        BookCollect bookCollect = new BookCollect();
        bookCollect.setBctBookId(bctBookId);
        bookCollect.setCollUserId(collUserId);
        bookCollect.setBctUserId(userInfoMapper.queryUserByEmail(userEmail).getUserId());
        bookCollectMapper.deleteCollect(bookCollect);
        bookInfoMapper.updateBookCommCount(bctBookId, StringUtils.USER_CANCEL_COLLECT);
        userInfoMapper.updateUserCollectNum(collUserId, StringUtils.USER_CANCEL_COLLECT);
        return AjaxResult.success("取消收藏成功");
    }

    /**
     * 用户查看收藏
     *
     * @param collUserId 收藏用户id
     */
    public PageInfo<BookInfoWithBLOBs> queryUserCollBook(int collUserId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BookInfoWithBLOBs> bookPage = new PageInfo<>(bookInfoMapper.queryUserCollBook(collUserId));
        for (BookInfoWithBLOBs bookInfo : bookPage.getList()) {
            bookInfo.setCurrUserCollect("1");
        }
        return bookPage;
    }
}
