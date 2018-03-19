package com.lala.lashop.base;


import com.lala.lashop.utils.L;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import okhttp3.MultipartBody;

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
        L.e("参数：" + params.toString());
        return params;
    }

    public MultipartBody.Builder getBody() {
        Map<String, String> map = getParams();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        Set keySet = map.keySet(); // key的set集合
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String k = it.next().toString(); // key
            String v = map.get(k).toString();  //value
            System.out.println("Key:" + k + " Value:" + v);
            builder.addFormDataPart(k, v);
        }
        return builder;
    }

}
