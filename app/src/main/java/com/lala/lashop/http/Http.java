package com.lala.lashop.http;

import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.CategoryBean;
import com.lala.lashop.ui.home.bean.HomeBean;
import com.lala.lashop.ui.home.bean.ShopsBean;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.ui.user.bean.ProvinceBean;
import com.lala.lashop.ui.user.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
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
    Observable<HttpResult<HomeBean>> getHome();

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
     * 商品详情
     * shopid 商品id
     * userid user 用户user_id
     */
    @POST("shopHandler/shopinfo.action")
    Observable<HttpResult<ShopInfoBean>> shops_info(@Body RequestBody body);

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
    Observable<HttpResult<List<ProvinceBean>>> address_province(@Body RequestBody body);

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
     * addressid
     */
    @POST("addressHandler/update.action")
    Observable<HttpResult> address_update(@Body RequestBody body);

    /**
     * 删除地址
     * user_id 用户id
     * address 地址json
     */
    @POST("addressHandler/delete.action")
    Observable<HttpResult> address_delete(@Body RequestBody body);

    /**
     * 查询地址
     * user_id 用户id
     */
    @POST("addressHandler/getList.action")
    Observable<HttpResult<List<AddressBean>>> address_list(@Body RequestBody body);

    /**
     * 地址详情
     * addressid 地址id
     */
    @POST("addressHandler/getAddress.action")
    Observable<HttpResult> address_detail(@Body RequestBody body);

    /**
     * 添加收藏
     * 用户user id
     * 商品shopid
     */
    @POST("collectHandler/add.action")
    Observable<HttpResult> coll_add(@Body RequestBody body);

    /**
     * 收藏列表
     * 用户user id
     */
    @POST("collectHandler/getList.action")
    Observable<HttpResult<List<CollBean>>> coll_list(@Body RequestBody body);

    /**
     * 删除收藏
     * 收藏collectid
     * 用户user_id
     */
    @POST("collectHandler/delete.action")
    Observable<HttpResult> coll_delete(@Body RequestBody body);

    /**
     * 判断是否收藏
     * user_id 用户user_id
     * shop_id 商品id
     * <p>
     * return 1:已收藏 0未收藏
     */
    @POST("collectHandler/sole.action")
    Observable<HttpResult> coll_check(@Body RequestBody body);

    /**
     * 购物车列表
     * admin_id 用户user_id
     */
    @POST("myOrderHandler/mycar.action")
    Observable<HttpResult<List<CartBean>>> cart_list(@Body RequestBody body);

    /**
     * 添加到购物车
     * shopid 商品id
     * sp_count 购买数量
     * color 颜色
     * gui 规格
     * youfei 邮费
     * user_id 用户id
     */
    @POST("myOrderHandler/tobuy.action")
    Observable<HttpResult> cart_add(@Body RequestBody body);

    /**
     * 购物车删除
     * orderid 订单id
     */
    @POST("myOrderHandler/delcar.action")
    Observable<HttpResult> cart_delete(@Body RequestBody body);

    /**
     * 立即购买
     * userid 用户user_id
     * shopid 商品id
     * sp_count 商品数量
     * youfei  邮费
     */
    @POST("myOrderHandler/buyNow.action")
    Observable<HttpResult> shop_buyNow(@Body RequestBody body);

    /**
     * shopid  商品ID
     * userid   用户ID
     * color   商品颜色
     * gui   商品规格
     */
    @POST("myOrderHandler/jiesuan.action")
    Observable<HttpResult> shop_jiesuan(@Body RequestBody body);
}