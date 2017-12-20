package com.zxx.myapp3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;
import com.zxx.myapp3.activity.LoginActivity;
import com.zxx.myapp3.activity.Main2Activity;

import scut.carson_ho.kawaii_loadingview.Kawaii_LoadingView;

public class MainActivity extends AppCompatActivity {

    private Kawaii_LoadingView kawaii_loadingView;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //在自己的应用初始Activity中加入如下两行代码
        RefWatcher refWatcher = MyApp.getRefWatcher(this);
        refWatcher.watch(this);

        sp = getSharedPreferences("sp", MODE_PRIVATE);

        kawaii_loadingView = findViewById(R.id.Kawaii_LoadingView);
        kawaii_loadingView.startMoving();//启动动画

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //点击跳转
                boolean isfirst = sp.getBoolean("isfirst", false);
                if(isfirst){
                    //第二次
                    //跳转到主页面
                    kawaii_loadingView.stopMoving();//结束动画
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                }else{
                    kawaii_loadingView.stopMoving();//结束动画
                    //第一次跳转到登录页面
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                }
            }
        },3000);



    }
}
