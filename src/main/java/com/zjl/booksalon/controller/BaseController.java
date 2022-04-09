package com.zjl.booksalon.controller;

import com.zjl.booksalon.commons.result.AjaxResult;
import com.zjl.booksalon.commons.result.AjaxResultPage;
import com.zjl.booksalon.commons.result.HttpStatus;
import com.zjl.booksalon.entity.UserInfo;
import com.zjl.booksalon.service.BookCommService;
import com.zjl.booksalon.service.BookService;
import com.zjl.booksalon.service.LoginService;
import com.zjl.booksalon.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ZJL
 * @Date: 2022/4/7 11:29
 * @Description:
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCommService bookCommService;

    @GetMapping("/comList")   //获取评论列表
    public AjaxResult getBookCommList(@RequestParam("bookName") String bookName, @RequestParam("pageNum") int pageNum,
                                      @RequestParam("pageSize") int pageSize) {
        return AjaxResultPage.success(bookCommService.getBookAllcomm(bookName, pageNum, pageSize));
    }

    //书籍推荐列表
    @PostMapping("/getBookPage")
    public AjaxResult queryBookpage(@RequestParam("search") String search, @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize, @RequestParam("userId") String userId) {
        return AjaxResultPage.success(bookService.getBookPage(search, pageNum, pageSize, userId));
    }

    //获取书籍热榜
    @PostMapping("/getHotBook")
    public AjaxResult getHotBookPage(@RequestParam("search") String search, @RequestParam("pageNum") int pageNum,
                                     @RequestParam("pageSize") int pageSize, @RequestParam("userId") String userId) {
        return AjaxResultPage.success(bookService.getHotBookPage(search, pageNum, pageSize, userId));
    }

    //用户登录接口
    @PostMapping("/login")
    public AjaxResult login(@RequestBody UserInfo userInfo) {
        return loginService.login(userInfo);
    }

    //用户注册、修改账号密码操作获取对应验证码
    @PostMapping("/getRegisterCode")
    public AjaxResult register(@RequestBody UserInfo userInfo, @RequestParam("titleType") String titleType) {
        return loginService.getRegisterCode(userInfo, titleType);
    }

    //验证用户注册，修改密码验证码是否正确，并进行数据库的持久化操作
    @PostMapping("/updateAndRegister")
    public AjaxResult updateUserInfo(@RequestBody UserInfo userInfo, @RequestParam("authCod") String authCode,
                                     @RequestParam("titleType") String titleType) {
        return loginService.registerAndUpdate(userInfo, authCode, titleType);
    }

    //没有权限，提醒用户登录
    @RequestMapping("/toLogin")
    public AjaxResult toLogin() {
        return AjaxResult.error(HttpStatus.UNAUTHORIZED, "请先登录");
    }

    //提醒用户没有操作权限
    @RequestMapping("/unauthor")
    public AjaxResult unauthor() {
        return AjaxResult.error(HttpStatus.UNAUTHORIZED, "没有权限");
    }

    //获取完整 用户信息
    @GetMapping("/getUser")
    public AjaxResult queryUser(@RequestParam("userEmail") String userEmail) {
        return userInfoService.queryUser(userEmail);
    }

    //过滤用户没有登录的请求
    @RequestMapping("/filterNoLogin")
    public AjaxResult filterRemind(HttpServletRequest request) {
        String msg = request.getAttribute("msg").toString();
        request.removeAttribute("msg");
        return AjaxResult.error(HttpStatus.UNAUTHORIZED, msg);
    }

    @RequestMapping("/filterErrorToken")
    public AjaxResult filterErrorToken(HttpServletRequest request) {
        String msg = request.getAttribute("msg").toString();
        request.removeAttribute("msg");
        return AjaxResult.error(HttpStatus.UNAUTHORIZED, msg);
    }


}
