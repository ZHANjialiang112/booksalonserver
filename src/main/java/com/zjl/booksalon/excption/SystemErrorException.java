package com.zjl.booksalon.excption;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 23:30
 * @Description:
 */
public class SystemErrorException extends EventException {

    private final static int CODE = 500;

    private final static String SYSTEM_ERROR = "系统出现错误，%s，请重试！";

    public SystemErrorException(String msg) {
        super(CODE, String.format(SYSTEM_ERROR, msg));
    }
}
