package com.lala.lashop.http;

import com.lala.lashop.ui.home.bean.BannerBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by JX on 2018/3/19.
 */

public interface Http {

    @GET("advHandler/banner.action")
    Observable<HttpResult<List<BannerBean>>> getBanner();

}
