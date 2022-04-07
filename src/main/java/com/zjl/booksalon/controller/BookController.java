package com.zjl.booksalon.controller;

import com.zjl.booksalon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZJL
 * @Date: 2022/4/1 20:30
 * @Description:
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    //@PostMapping("/getBookPage")
    //public AjaxResult queryBookpage(@RequestBody BookInfo bookInfo, @RequestParam("pageNum") int pageNum,
    //                                @RequestParam("pageSize") int pageSize) {
    //    return AjaxResultPage.success(bookService.getBookPage(bookInfo, pageNum, pageSize));
    //}
}
