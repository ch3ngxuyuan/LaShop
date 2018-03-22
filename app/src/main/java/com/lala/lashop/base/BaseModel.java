package com.lala.lashop.base;


import com.lala.lashop.utils.L;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by JX on 2017/12/20.
 */

public class BaseModel {

    private Map<String, String> mParamsMap;

    public BaseModel() {
        mParamsMap = new TreeMap<>();
    }

    /**
     * 添加参数
     *
     * @param key
     * @param value
     * @return
     */
    public BaseModel p(String key, String value) {
        mParamsMap.put(key, value);
        return this;
    }

    /**
     * 添加参数
     *
     * @param key
     * @param value
     * @return
     */
    public BaseModel p(String key, int value) {
        mParamsMap.put(key, String.valueOf(value));
        return this;
    }

    public Map<String, String> getParams() {
        Map<String, String> params = new TreeMap<>();
        params.putAll(mParamsMap);
        mParamsMap.clear();

        return params;
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

//    public MultipartBody.Builder getBody() {
//        Map<String, String> map = getParams();
//        JSONObject para = new JSONObject();
//
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//
//        Set keySet = map.keySet(); // key的set集合
//        Iterator it = keySet.iterator();
//        try {
//            while (it.hasNext()) {
//                String k = it.next().toString(); // key
//                String v = map.get(k).toString();  //value
//
//                para.put(k, v);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        RequestBody body = RequestBody.create(JSON, para.toString());
//
//        builder.addPart(body);
////        builder.addPart(Headers.of("Content-Type: application/json","Accept: application/json"), body);
//        L.e("参数：" + para.toString());
//
//        return builder;
//    }

    public RequestBody getRequestBody() {
        Map<String, String> map = getParams();
        JSONObject para = new JSONObject();

        Set keySet = map.keySet(); // key的set集合
        Iterator it = keySet.iterator();
        try {
            while (it.hasNext()) {
                String k = it.next().toString(); // key
                String v = map.get(k).toString();  //value

                para.put(k, v);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, para.toString());
        L.e("参数：" + para.toString());

        return body;
    }

}
