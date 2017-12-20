package com.zxx.myapp3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxx.myapp3.R;
import com.zxx.myapp3.util.GlideCacheUtil;

/**
 * 设置页面
 */
public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView shezhi_black;
    private TextView shezhi_tv_gengxin;
    private TextView shezhi_tv_yijian;
    private TextView shezhi_tv_map;
    private TextView shezhi_tv_huancun;
    private TextView shezhi_tv_hcnum;
    private Button shezhi_login_clear;

    private SharedPreferences sp;
    private GlideCacheUtil glideCacheUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initView();
        //缓存数量
        glideCacheUtil = new GlideCacheUtil();
        shezhi_tv_hcnum.setText(glideCacheUtil.getInstance().getCacheSize(this));


    }

    private void initView() {
        //返回键
        shezhi_black = findViewById(R.id.shezhi_black);
        //检查更新
        shezhi_tv_gengxin = findViewById(R.id.shezhi_tv_gengxin);
        //意见反馈
        shezhi_tv_yijian = findViewById(R.id.shezhi_tv_yijian);

        //高德地图
        shezhi_tv_map = findViewById(R.id.shezhi_tv_map);
        //清除缓存
        shezhi_tv_huancun = findViewById(R.id.shezhi_tv_huancun);
        //缓存大小
        shezhi_tv_hcnum = findViewById(R.id.shezhi_tv_hcnum);
        //退出登录
        shezhi_login_clear = findViewById(R.id.shezhi_login_clear);

        //点击事件
        shezhi_black.setOnClickListener(this);
        shezhi_tv_gengxin.setOnClickListener(this);
        shezhi_tv_yijian.setOnClickListener(this);
        shezhi_tv_map.setOnClickListener(this);
        shezhi_tv_huancun.setOnClickListener(this);
        shezhi_login_clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shezhi_black:
                finish();//返回
                break;
            case R.id.shezhi_tv_gengxin:
                Toast.makeText(this, "检查更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi_tv_yijian:
                Toast.makeText(this, "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi_tv_map:
                Toast.makeText(this, "高德地图", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi_tv_huancun:
                //清除缓存
                glideCacheUtil.clearImageDiskCache(this);
                Toast.makeText(this, "清除缓存", Toast.LENGTH_SHORT).show();
                shezhi_tv_hcnum.setText("");

                break;
            case R.id.shezhi_login_clear:
                //点击退出登录
                //清除SharedPreferences
                sp = getSharedPreferences("sp", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.clear();
                edit.commit();

                Intent intent = new Intent(SheZhiActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();//结束

                break;
        }
    }
}
