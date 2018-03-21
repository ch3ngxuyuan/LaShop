package com.lala.lashop.http;

import com.lala.lashop.ui.home.bean.BannerBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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
     * phone
     * pwd
     * reg_from 来源方式 3.安卓
     * account
     */
    @FormUrlEncoded
    @POST("userHandler/reg.action")
    Observable<HttpResult> user_register(@FieldMap Map<String, String> map);

    /**
     * 登录
     * phone
     * pwd
     */
    @FormUrlEncoded
    @POST("userHandler/login.action")
    Observable<HttpResult> user_login(@FieldMap Map<String, String> map);

    /**
     * 添加地址
     * user_id
     * mobile
     * provincialName
     * cityName
     * areaName
     * addressDetail
     * m_id 是否默认 1\0
     * fullName 名字
     */
    @FormUrlEncoded
    @POST("addressHandler/add.action")
    Observable<HttpResult> address_add(@FieldMap Map<String, String> map);

    /**
     * 更新地址
     * user_id
     * mobile
     * provincialName
     * cityName
     * areaName
     * addressDetail
     * m_id 是否默认 1\0
     * fullName 名字
     */
    @FormUrlEncoded
    @POST("addressHandler/update.action")
    Observable<HttpResult> address_update(@FieldMap Map<String, String> map);

    /**
     * 删除地址
     * user_id 用户id
     * address 地址json
     */
    @FormUrlEncoded
    @POST("addressHandler/delete.action")
    Observable<HttpResult> address_delete(@FieldMap Map<String, String> map);

    /**
     * 查询地址
     * user_id 用户id
     */
    @FormUrlEncoded
    @POST("addressHandler/getList.action")
    Observable<HttpResult> address_list(@FieldMap Map<String, String> map);

    /**
     * 地址详情
     * addressid 地址id
     */
    @FormUrlEncoded
    @POST("addressHandler/getAddress.action")
    Observable<HttpResult> address_detail(@FieldMap Map<String, String> map);
}