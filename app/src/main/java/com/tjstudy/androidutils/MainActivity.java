package com.tjstudy.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tjstudy.autils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private ToastUtils toastUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击事件：打印toast
     *
     * @param view
     */
    public void testToast(View view) {
        toastUtils = ToastUtils.newInstance(this);
        toastUtils.show("打印toast");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        toastUtils.destory();
    }
}