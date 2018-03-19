package com.lala.lashop.http;

/**
 * Created by JX on 2018/3/19.
 */

public class HttpResult<T> {

    private int code;
    private T mess;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getMess() {
        return mess;
    }

    public void setMess(T mess) {
        this.mess = mess;
    }
}
