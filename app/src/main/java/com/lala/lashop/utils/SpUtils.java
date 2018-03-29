package com.lala.lashop.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.lala.lashop.app.App;
import com.lala.lashop.ui.user.bean.UserBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by JX on 2017/12/29.
 */

public class SpUtils {

    private static final String USER_KEY = "user_key";

    /**
     * 保存在手机的文件名
     */
    private static final String FILE_NAME = "lashop_data";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    public static void putUser(UserBean userBean) {
        put(App.getContext(), USER_KEY, new Gson().toJson(userBean));
    }

    public static UserBean getUser() {
        return new Gson().fromJson(getString(USER_KEY, ""), UserBean.class);
    }

    public static String getString(String key, String defValue) {
        return App.getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getString(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return App.getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getInt(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return App.getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(key, defValue);
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}
