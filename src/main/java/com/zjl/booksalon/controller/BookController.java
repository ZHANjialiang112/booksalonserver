package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.AjaxResultPage;
import com.zjl.booksalon.entity.BookInfo;
import com.zjl.booksalon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getBookPage")
    public AjaxResult queryBookpage(@RequestBody BookInfo bookInfo, @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        return AjaxResultPage.success(bookService.getBookPage(bookInfo, pageNum, pageSize));
    }
}
