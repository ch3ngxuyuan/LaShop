package com.lala.lashop.http.exception;

import retrofit2.HttpException;

/**
 * Created by JX on 2017/12/20.
 */

public class ApiException extends Exception {

    public static final int SERVICE_ERROR = 10001; //服务器错误
    public static final int INTERNET_ERROR = 10002; //网络错误

    private int code;
    private String message;


    public ApiException(Throwable e) {
        super(e);
        if (e instanceof HttpException) {
            code = SERVICE_ERROR;
        } else {
            code = INTERNET_ERROR;
        }

    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
