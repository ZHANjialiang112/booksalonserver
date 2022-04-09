package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.AjaxResultPage;
import com.zjl.booksalon.service.BookCollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZJL
 * @Date: 2022/4/9 16:29
 * @Description:
 */
@RestController
@RequestMapping("/bookColl")
public class BookCollectController {

    @Autowired
    private BookCollService bookCollService;

    /**
     * 用户收藏书籍
     *
     * @param collUserId 收藏用户的id
     * @param bctBookId  收藏书籍的id
     * @param userEmail  发布书籍的用户邮箱
     * @return
     */
    @PostMapping("/addColl")
    public AjaxResult userAddCollect(@RequestParam("collUserId") Integer collUserId, @RequestParam("bctBookId") Integer bctBookId,
                                     @RequestParam("userEmail") String userEmail) {
        return bookCollService.userAddCollect(collUserId, bctBookId, userEmail);
    }

    /**
     * 用户取消收藏
     *
     * @param collUserId 收藏用户的id
     * @param bctBookId  收藏书籍的id
     * @param userEmail  发布书籍的用户邮箱
     * @return
     */
    @PostMapping("/cancelColl")
    public AjaxResult userCancelCollect(@RequestParam("collUserId") Integer collUserId, @RequestParam("bctBookId") Integer bctBookId,
                                        @RequestParam("userEmail") String userEmail) {
        return bookCollService.userCancelCollect(collUserId, bctBookId, userEmail);
    }


    /**
     * 用户查看收藏的书籍
     *
     * @param collUserId 收藏用户的id
     * @return
     */
    @PostMapping("/queryCollBook")
    public AjaxResult findCollBook(@RequestParam("collUserId") Integer collUserId, @RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize) {
        return AjaxResultPage.success(bookCollService.queryUserCollBook(collUserId, pageNum, pageSize));
    }

}

