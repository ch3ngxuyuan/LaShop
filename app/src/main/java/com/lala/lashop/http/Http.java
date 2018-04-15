package com.lala.lashop.http;

import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.CategoryBean;
import com.lala.lashop.ui.home.bean.HomeBean;
import com.lala.lashop.ui.home.bean.ShopsBean;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.shop.bean.ConfirmBean;
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.ui.user.bean.DiscountBean;
import com.lala.lashop.ui.user.bean.IndentBean;
import com.lala.lashop.ui.user.bean.PointBean;
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
    Observable<HttpResult<Integer>> coll_check(@Body RequestBody body);

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
     * 商品详情，立即购买
     * shopid  商品ID
     * userid   用户ID
     * color   商品颜色
     * gui   商品规格
     */
    @POST("myOrderHandler/jiesuan.action")
    Observable<HttpResult<ConfirmBean>> shop_jiesuan(@Body RequestBody body);

    /**
     * 获取用户信息
     * id 用户ID
     */
    @POST("userHandler/getUser.action")
    Observable<HttpResult<UserBean>> user_info(@Body RequestBody body);

    /**
     * 拼接订单
     * ids  订单id
     * spids 商品id
     * counts 商品数量
     * simgs 商品图片
     * prices 商品价格
     * yunfeis 商品运费
     */
    @POST("myOrderHandler/pingjieOrder.action")
    Observable<HttpResult<ConfirmBean>> shop_pinjie(@Body RequestBody body);

    /**
     * 获取结算信息
     * userid 用户user_id
     * shopid 商品id
     * aid 地址id
     * distribution 留言
     * sp_total 商品总价格
     * orderids 订单id
     */
    @POST("myOrderHandler/topayorder.action")
    Observable<HttpResult> shop_topayorder(@Body RequestBody body);

    /**
     * 订单列表
     * user_id
     * or_flag  0 ： 未支付 1,2：未收货 4： 未评价
     * orid  订单号
     */
    @POST("myOrderHandler/getList.action")
    Observable<HttpResult<IndentBean>> indent_list(@Body RequestBody body);

    /**
     * 用户的积分列表
     * user_id
     */
    @POST("userHandler/getUserCredit.action")
    Observable<HttpResult<List<PointBean>>> credit_list(@Body RequestBody body);

    /**
     * 获取用户当前积分
     * user_id  用户user_id
     */
    @POST("userHandler/nowCredit.action")
    Observable<HttpResult<String>> credit_user(@Body RequestBody body);

    /**
     * 获取默认地址
     * userid
     */
    @POST("myOrderHandler/getMoren.action")
    Observable<HttpResult<AddressBean>> shop_address(@Body RequestBody body);

    /**
     * 发票列表
     * key:user_id
     * moren = 1 ,获取默认发票
     */
    @POST("invoiceHandler/list.action")
    Observable<HttpResult<List<InvoiceBean>>> invoice_list(@Body RequestBody body);

    /**
     * 添加发票抬头
     * key:user_id,head,taxnumber,moren
     */
    @POST("invoiceHandler/add.action")
    Observable<HttpResult> invoice_add(@Body RequestBody body);

    /**
     * 优惠券列表
     * uid
     */
    @POST("couponsHandler/list.action")
    Observable<HttpResult<List<DiscountBean>>> discount_list(@Body RequestBody body);

    /**
     * 使用优惠券
     * id 优惠券ID
     * ordid 订单ID
     */
    @POST("couponsHandler/useCoupons.action")
    Observable<HttpResult> shop_discount(@Body RequestBody body);

    /**
     * 删除优惠券
     * cid  用户领取的优惠券ID
     */
    @POST("couponsHandler/del.action")
    Observable<HttpResult> discount_delete(@Body RequestBody body);
}