package com.zjl.booksalon.excption;

/**
 * @author wenman
 * @Auther: ZJL
 * @Date: 2021/12/11 14:33
 * @Description:
 */
public class EventException extends RuntimeException{

    private int code;
    private String msg;

    public EventException(){}

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public EventException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
