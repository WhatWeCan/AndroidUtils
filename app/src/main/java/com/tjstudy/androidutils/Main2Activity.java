package com.tjstudy.androidutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tjstudy.autils.SPUtils;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SPUtils spUtils = SPUtils.newInstance(this).setSPFileName("sp_name");
        Log.e(TAG, "onCreate: sputils" + spUtils);
    }
}
