package com.tjstudy.autils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 工具类
 */

public class SPUtils {
    private static SPUtils spUtils;
    private String fileName = "share_data";
    private SharedPreferences mSp;
    private Context mContext;

    private SPUtils(Context context) {
        mContext = context;
        mSp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public static SPUtils newInstance(Context context) {
        if (spUtils == null) {
            synchronized (SPUtils.class) {
                if (spUtils == null) {
                    spUtils = new SPUtils(context);
                }
            }
        }
        return spUtils;
    }

    /**
     * 设置sp存储的文件名
     *
     * @param fileName
     * @return
     */
    public SPUtils setSPFileName(String fileName) {
        mSp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return this;
    }

    /**
     * 存放数据到sp
     *
     * @return
     */
    public void put(String key, Object object) {
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
     *
     * @param key
     * @param defaultObj
     * @return
     */
    public String getString(String key, String defaultObj) {
        return mSp.getString(key, defaultObj);
    }

    /**
     * 获取指定键的值
     *
     * @param key
     * @param defaultObj
     * @return
     */
    public Integer getInt(String key, Integer defaultObj) {
        return mSp.getInt(key, defaultObj);
    }

    /**
     * 获取指定键的值
     *
     * @param key
     * @param defaultObj
     * @return
     */
    public Boolean getBoolean(String key, Boolean defaultObj) {
        return mSp.getBoolean(key, defaultObj);
    }

    /**
     * 获取指定键的值
     *
     * @param key
     * @param defaultObj
     * @return
     */
    public Float getFloat(String key, Float defaultObj) {
        return mSp.getFloat(key, defaultObj);
    }

    /**
     * 获取指定键的值
     *
     * @param key
     * @param defaultObj
     * @return
     */
    public Long getLong(String key, Long defaultObj) {
        return mSp.getLong(key, defaultObj);
    }

    /**
     * 移除指定键值
     *
     * @param key
     */
    public void remove(String key) {
        mSp.edit().remove(key).apply();
    }

    /**
     * 清楚所有键值
     */
    public void clearAll() {
        mSp.edit().clear().apply();
    }
}
