package com.zjl.booksalon.commons.result;

public class RestJson {
    private String code;
    private String msg;
    private Object data;

    private RestCode restCode;

    public RestJson(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestJson(RestCode restCode) {
        this.code = restCode.getCode();
        this.msg = restCode.getMag();
    }

    public RestJson(Object data, RestCode restCode) {
        this.data = data;
        this.msg = restCode.getMag();
        this.code = restCode.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
