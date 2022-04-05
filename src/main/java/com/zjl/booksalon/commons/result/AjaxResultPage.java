package com.zjl.booksalon.commons.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: ZJL
 * @Date: 2022/4/5 17:57
 * @Description:
 */
public class AjaxResultPage extends AjaxResult {
    public static final Long serialVersionUID = 1L;


    public AjaxResultPage() {
    }


    public static AjaxResult success() {
        return AjaxResult.success();
    }

    //获取当前页信息
    public static AjaxResult success(PageInfo<?> pageInfo) {
        List<?> list = pageInfo.getList();
        return AjaxResult.success(list).put("total", pageInfo.getTotal());
    }

    public static AjaxResult success(String msg, PageInfo<?> pageInfo) {
        return AjaxResult.success(msg, pageInfo.getList()).put("total", pageInfo.getTotal());
    }


}

