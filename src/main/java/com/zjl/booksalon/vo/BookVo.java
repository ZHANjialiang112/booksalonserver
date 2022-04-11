package com.zjl.booksalon.vo;

import com.zjl.booksalon.entity.BookInfoWithBLOBs;

/**
 * @Auther: ZJL
 * @Date: 2022/4/11 22:47
 * @Description:
 */
public class BookVo extends BookInfoWithBLOBs {
    private String userImgurl;

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl;
    }
}
