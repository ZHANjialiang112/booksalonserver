package com.zjl.booksalon.excption;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/11 14:46
 * @Description:数据重复的异常处理
 */
public class DataDuplicateException extends EventException{
    private static final int CODE = 403;
    private static final String mailHadRegistered = "该%s用户已经注册，请登录~";

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param msg
     */
    public DataDuplicateException(String msg) {
//        格式化字符串返回
        super(CODE,String.format(mailHadRegistered,msg));
    }
}
