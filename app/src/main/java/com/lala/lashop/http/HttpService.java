package com.biguo.biguock.http;

import com.biguo.biguock.App;
import com.biguo.biguock.utils.L;
import com.biguo.biguock.utils.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JX on 2017/12/20.
 */

public class HttpService {

    public static <T> T execute(final Class<T> service) {
        return getBuilder()
                .client(getHttpClient())
                .build().create(service);
    }

    private static Retrofit.Builder getBuilder() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiPath.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder;
    }

    private static OkHttpClient getHttpClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        L.e("request_url:" + chain.request().url());
                        Request.Builder builder = chain.request().newBuilder();
                        if (App.getUser() != null) {
                            L.e("token:" + App.getUser().getToken());
                            builder.addHeader("token", App.getUser().getToken());
                        }
                        builder.addHeader("device", "Android")
                                .addHeader("version", Utils.getVersionName(App.getContext()));
                        return chain.proceed(builder.build());
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        return httpClient;
    }

}
