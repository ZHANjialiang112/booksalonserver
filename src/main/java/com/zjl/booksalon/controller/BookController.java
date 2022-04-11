package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.AjaxResultPage;
import com.zjl.booksalon.entity.BookInfoWithBLOBs;
import com.zjl.booksalon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

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

    //获取用户书籍
    @PostMapping("/getUserBook")
    public AjaxResult queryBookpage(@RequestParam("userEmail") String userEmail, @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        return AjaxResultPage.success(bookService.getUserAllBook(userEmail, pageNum, pageSize));
    }

    //添加书籍
    @PostMapping("/addBook")
    public AjaxResult addNewBook(@RequestBody BookInfoWithBLOBs bookInfoWithBLOBs) {
        return AjaxResult.success(bookService.userAddNewBook(bookInfoWithBLOBs));
    }


    //获取前端上传的图片文件
    @PostMapping("/imgUpload")
    public AjaxResult previewImg(MultipartHttpServletRequest multiReq) throws IOException {
        MultipartFile avatar = multiReq.getFile("file");
        System.out.println(multiReq);
        if (Objects.isNull(avatar)) {
            return AjaxResult.error("请选择要上传的文件");
        }
        if (avatar.getSize() > 1024 * 1024 * 1024) {
            return AjaxResult.error("文件大小不能超过10M！");
        }
        //获取文件后缀
        assert avatar.getContentType() != null;
        if (avatar.getContentType().contains("image/png, image/jpeg, image/gif")) {
            return AjaxResult.error("请选择jpg,png格式的图片");
        }
        //File savePathFile = new File("C:\\Users\\wenman\\Desktop\\imageTest");
        File savePathFile = new File("H:\\graduations\\booksalonserver\\src\\main\\resources\\images");
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdirs();
        }
        String filename = System.currentTimeMillis() + avatar.getOriginalFilename();
        avatar.transferTo(new File("H:\\graduations\\booksalonserver\\src\\main\\resources\\images\\" + filename));
        return AjaxResult.success(filename);
    }
}
