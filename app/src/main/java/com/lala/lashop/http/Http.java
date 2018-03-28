package com.lala.lashop.http;

import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.CategoryBean;
import com.lala.lashop.ui.home.bean.ShopsBean;
import com.lala.lashop.ui.user.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
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
     * 首页数据
     */
    @POST("homeHandler/home.action")
    Observable<HttpResult> getHome();

    /**
     * 产品分类
     */
    @POST("homeHandler/category.action")
    Observable<HttpResult<List<CategoryBean>>> getCategory();

    /**
     * 分类查询
     * page， 当前第几页，默认1，第一页
     * sp_classification: 分类 small_id
     */
    @POST("homeHandler/minishopList.action")
    Observable<HttpResult<List<ShopsBean>>> cate_search(@Body RequestBody body);

    /**
     * shopid 商品id
     * userid user 用户user_id
     */
    @POST("shopHandler/shopinfo.action")
    Observable<HttpResult> shops_info(@Body RequestBody body);

    /**
     * 注册
     * phone
     * pwd
     * reg_from 来源方式 3.安卓
     * account
     */
    @POST("userHandler/reg.action")
    Observable<HttpResult> user_register(@Body RequestBody body);

    /**
     * 登录
     * phone
     * pwd
     */
    @POST("userHandler/login.action")
    Observable<HttpResult<UserBean>> user_login(@Body RequestBody body);

    /**
     * 查询省市区地址
     * pid 地区上级ID 如果为1，则查出的是省份
     */
    @POST("locationHandler/list.action")
    Observable<HttpResult> address_province(@Body RequestBody body);

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
    Observable<HttpResult> address_add(@Body RequestBody body);

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
    Observable<HttpResult> address_update(@Body RequestBody body);

    /**
     * 删除地址
     * user_id 用户id
     * address 地址json
     */
    @FormUrlEncoded
    @POST("addressHandler/delete.action")
    Observable<HttpResult> address_delete(@Body RequestBody body);

    /**
     * 查询地址
     * user_id 用户id
     */
    @FormUrlEncoded
    @POST("addressHandler/getList.action")
    Observable<HttpResult> address_list(@Body RequestBody body);

    /**
     * 地址详情
     * addressid 地址id
     */
    @FormUrlEncoded
    @POST("addressHandler/getAddress.action")
    Observable<HttpResult> address_detail(@Body RequestBody body);
}