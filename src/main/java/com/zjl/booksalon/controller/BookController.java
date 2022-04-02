package com.zjl.booksalon.controller;

import com.github.pagehelper.PageInfo;
import com.zjl.booksalon.entity.BookInfo;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
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

    @PostMapping("/getbookpage")
    public PageInfo<BookInfoWithBLOBs> queryBookpage(@RequestBody BookInfo bookInfo, @RequestParam("pageNum") int pageNum,
                                                     @RequestParam("pageSize") int pageSize) {
        return bookService.getBookPage(bookInfo, pageNum, pageSize);
    }
}
