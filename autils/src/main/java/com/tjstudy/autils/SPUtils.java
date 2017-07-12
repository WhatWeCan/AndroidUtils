package com.tjstudy.autils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 工具类
 */

public class SPUtils {
    private SPUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final String fileName = "share_data";

    /**
     * 存放数据到sp
     */
    public static void put(Context context, String key, Object object) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSp.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object).apply();
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object).apply();
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object).apply();
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object).apply();
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object).apply();
        } else {
            editor.putString(key, object.toString()).apply();
        }
    }

    /**
     * 获取指定键的值
     */
    public static String getString(Context context, String key, String defaultObj) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return mSp.getString(key, defaultObj);
    }

    /**
     * 获取指定键的值
     */
    public static Integer getInt(Context context, String key, Integer defaultObj) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return mSp.getInt(key, defaultObj);
    }

    /**
     * 获取指定键的值
     */
    public static Boolean getBoolean(Context context, String key, Boolean defaultObj) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return mSp.getBoolean(key, defaultObj);
    }

    /**
     * 获取指定键的值
     */
    public static Float getFloat(Context context, String key, Float defaultObj) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return mSp.getFloat(key, defaultObj);
    }

    /**
     * 获取指定键的值
     */
    public static Long getLong(Context context, String key, Long defaultObj) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return mSp.getLong(key, defaultObj);
    }

    /**
     * 移除指定键值
     */
    public static void remove(Context context, String key) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mSp.edit().remove(key).apply();
    }

    /**
     * 清楚所有键值
     */
    public static void clearAll(Context context) {
        SharedPreferences mSp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mSp.edit().clear().apply();
    }
}
