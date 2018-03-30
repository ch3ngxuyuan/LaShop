package com.lala.lashop.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.lala.lashop.utils.L;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by JX on 2018/3/30.
 */

public final class CusGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private Type mType;

    CusGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, Type type) {
        this.gson = gson;
        this.adapter = adapter;
        this.mType = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        HttpResult result;
        try {
            String body = value.string();
            L.e("body = " + body);
            result = gson.fromJson(body, HttpResult.class);

            int code = result.getCode();
            if (code == 200) {
                return gson.fromJson(body, mType);
            } else {
                return (T) gson.fromJson(body, HttpResult.class);
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            value.close();
        }
    }
}