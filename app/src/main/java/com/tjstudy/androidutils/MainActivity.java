package com.tjstudy.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tjstudy.autils.SPUtils;

public class MainActivity extends AppCompatActivity {

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
        SPUtils spUtils = SPUtils.newInstance(this).setSPFileName("sp_name");
        spUtils.put("mine", "tjstudy");
        Toast.makeText(this, (spUtils.getString("mine", null)), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}