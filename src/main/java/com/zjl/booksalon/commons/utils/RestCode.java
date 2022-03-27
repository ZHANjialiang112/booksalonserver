package com.zjl.booksalon.commons.utils;

public enum RestCode {
    /**
     * 请求成功，和请求失败的请求码
     */
    SUCCESS("200","成功"),
    ERROR("500","失败"),
    LOGOUT("1001","该账户没有登录！");




    private String code;
    private String mag;

    RestCode(String code, String mag) {
        this.code = code;
        this.mag = mag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        return "RestCode{" +
                "code='" + code + '\'' +
                ", mag='" + mag + '\'' +
                '}';
    }
}
