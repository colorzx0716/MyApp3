package com.zxx.myapp3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zxx.myapp3.R;

/**
 * 我的作品主页
 */
public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }


    }
}
