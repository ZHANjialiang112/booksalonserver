package com.zjl.booksalon.commons.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/4 13:30
 * @Description:
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private final static String PASSWORD_SALT = "BOOKSALON";

    public static boolean isNotNull(Object data) {
        return data != null;
    }

    public static String passwordMd5(String pwd) {
        StringBuilder stringBuilder = new StringBuilder(pwd);
        stringBuilder.append(PASSWORD_SALT);
        String s = String.valueOf(stringBuilder);
        return DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean isMatch(String url) {
        //判断url请求中是否以/base路径开始
        return url.startsWith("/base");
    }
}
