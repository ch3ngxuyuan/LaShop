package com.lala.lashop.utils;

import java.util.List;

/**
 * Created by JX on 2017/4/28.
 */

public class ArrayUtil {

    public static <V> boolean isEmpty(List<V> sourceArray) {
        return (sourceArray == null || sourceArray.size() == 0);
    }

}
