package com.tjstudy.autils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 *
 * @author tjstudy
 */

public class ToastUtils {
    private static ToastUtils mToastUtils;
    private Toast mToast;

    private ToastUtils(Context context) {
        mToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
    }

    public static ToastUtils newInstance(Context context) {
        if (mToastUtils == null) {
            synchronized (ToastUtils.class) {
                if (mToastUtils == null) {
                    mToastUtils = new ToastUtils(context);
                }
            }
        }
        return mToastUtils;
    }

    /**
     * 显示toast
     *
     * @param mess
     */
    public void show(String mess) {
        mToast.setText(mess);
        mToast.show();
    }

    /**
     * 显示toast
     *
     * @param resId
     */
    public void show(int resId) {
        mToast.setText(resId);
        mToast.show();
    }

    /**
     * 销毁
     */
    public void destory() {
        if (null != mToast) {
            mToast.cancel();
            mToast = null;
        }
        mToastUtils = null;
    }
}
