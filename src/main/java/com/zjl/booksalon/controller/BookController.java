package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.AjaxResultPage;
import com.zjl.booksalon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/getUserBook")
    public AjaxResult queryBookpage(@RequestParam("userEmail") String userEmail, @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        return AjaxResultPage.success(bookService.getUserAllBook(userEmail, pageNum, pageSize));
    }
}
