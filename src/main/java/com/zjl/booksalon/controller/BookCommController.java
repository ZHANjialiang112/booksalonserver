package com.zjl.booksalon.controller;

import com.zjl.booksalon.service.BookCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZJL
 * @Date: 2022/4/5 23:23
 * @Description:
 */
@RestController
@RequestMapping("/bookComm")
public class BookCommController {

    @Autowired
    private BookCommService bookCommService;

    //@GetMapping("/comList")   //获取评论列表
    //public AjaxResult getBookCommList(@RequestParam("bookName") String bookName, @RequestParam("pageNum") int pageNum,
    //                                  @RequestParam("pageSize") int pageSize) {
    //    return AjaxResultPage.success(bookCommService.getBookAllcomm(bookName, pageNum, pageSize));
    //}
}
