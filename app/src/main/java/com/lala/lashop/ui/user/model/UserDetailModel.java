package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by JX on 2018/4/19.
 */

public class UserDetailModel extends BaseModel {

    public Observable<HttpResult> user_updateinfo(String id, String uName, String uImg, String uSex, String uEmail, String uBirthday) {
        p("id", id).p("uName", uName).p("uImg", uImg).p("uSex", uSex).p("uEmail", uEmail).p("uBirthday", uBirthday);
        return HttpService.execute(Http.class).user_updateinfo(getRequestBody());
    }

    public Observable<HttpResult<String>> upload_image(File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uImg", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        return HttpService.execute(Http.class).upload_image(builder.build());
    }

}
