package com.lala.lashop.http;

import com.lala.lashop.ui.home.bean.BannerBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by JX on 2018/3/19.
 */

public interface Http {

    /**
     * 首页轮播图
     *
     * @return
     */
    @POST("advHandler/banner.action")
    Observable<HttpResult<List<BannerBean>>> getBanner();

    /**
     * 注册
     *
     * @param phone
     * @param pwd
     * @param reg_from 来源方式 3.安卓
     * @param account
     * @return
     */
    @FormUrlEncoded
    @POST("userHandler/reg.action")
    Observable<HttpResult> register(String phone, String pwd, int reg_from, String account);

    /**
     * 登录
     *
     * @param phone
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST("userHandler/login.action")
    Observable<HttpResult> login(String phone, String pwd);

}