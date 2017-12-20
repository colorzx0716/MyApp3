package com.zxx.myapp3.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zxx.myapp3.R;
import com.zxx.myapp3.adapter.MyListAdapter;
import com.zxx.myapp3.dagger2.DaggerMyComponent;
import com.zxx.myapp3.dagger2.MyComponent;
import com.zxx.myapp3.dagger2.MyModule;
import com.zxx.myapp3.entity.UserInfoBean;
import com.zxx.myapp3.fragment.Fragment1;
import com.zxx.myapp3.fragment.Fragment2;
import com.zxx.myapp3.fragment.Fragment3;
import com.zxx.myapp3.fragment.Fragment4;
import com.zxx.myapp3.presenter.UserInfoPresenter;
import com.zxx.myapp3.util.GlideCircleTransform;
import com.zxx.myapp3.util.ShareprefrensUtils;
import com.zxx.myapp3.view.UserInfoView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 主要的页面
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener,UserInfoView {

    private ImageView main2_touxiang;
    private TextView main2_head_tv;
    private ImageView main2_xie;
    private ImageView main2_tuijian;
    private TextView main2_tv_tuijian;
    private ImageView main2_duanzi;
    private TextView main2_tv_duanzi;
    private ImageView main2_shipin;
    private TextView main2_tv_shipin;
    private ImageView main2_faxian;
    private TextView main2_tv_faxian;
    private LinearLayout main2_lin1;
    private LinearLayout main2_lin2;
    private LinearLayout main2_lin3;
    private LinearLayout main2_lin4;

    private List<String> tvs = new ArrayList<>();
    private List<Integer> imgs = new ArrayList<>();
    private ImageView left_touxiang;
    private TextView left_tv_nicheng;
    private ListView left_lv;
    private LinearLayout left_zuopin;
    private LinearLayout left_shezhi;
    private DrawerLayout drawer_layout;

    @Inject
    UserInfoPresenter userInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initList();//添加文字
        initView();

        //获取桥梁
        MyComponent component = DaggerMyComponent.builder().myModule(new MyModule(this)).build();
        component.inject(this);

        String uid = (String) ShareprefrensUtils.get(this, "uid", "");
        userInfoPresenter.rele(uid);

    }

    private void initList() {
        tvs.add("我的关注");
        tvs.add("我的收藏");
        tvs.add("搜索好友");
        tvs.add("消息通知");

        imgs.add(R.mipmap.raw_guanzhu);
        imgs.add(R.mipmap.raw_shoucang);
        imgs.add(R.mipmap.raw_sou);
        imgs.add(R.mipmap.raw_xiaoxi);
    }

    private void initView() {
        main2_touxiang = findViewById(R.id.main2_touxiang);
        main2_head_tv = findViewById(R.id.main2_head_tv);
        main2_xie = findViewById(R.id.main2_xie);
        drawer_layout = findViewById(R.id.drawer_layout);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        main2_tuijian = findViewById(R.id.main2_tuijian);
        main2_tv_tuijian = findViewById(R.id.main2_tv_tuijian);

        main2_duanzi = findViewById(R.id.main2_duanzi);
        main2_tv_duanzi = findViewById(R.id.main2_tv_duanzi);

        main2_shipin = findViewById(R.id.main2_shipin);
        main2_tv_shipin = findViewById(R.id.main2_tv_shipin);

        main2_faxian = findViewById(R.id.main2_faxian);
        main2_tv_faxian = findViewById(R.id.main2_tv_faxian);

        main2_lin1 = findViewById(R.id.main2_lin1);
        main2_lin2 = findViewById(R.id.main2_lin2);
        main2_lin3 = findViewById(R.id.main2_lin3);
        main2_lin4 = findViewById(R.id.main2_lin4);

        //左边的控件
        left_touxiang = findViewById(R.id.left_touxiang);
        left_tv_nicheng = findViewById(R.id.left_tv_nicheng);
        left_lv = findViewById(R.id.left_lv);
        left_zuopin = findViewById(R.id.left_zuopin);
        left_shezhi = findViewById(R.id.left_shezhi);

        MyListAdapter myListAdapter = new MyListAdapter(this,tvs,imgs);
        left_lv.setAdapter(myListAdapter);

        //点击条目
        left_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    //我的关注
                    Intent intent = new Intent(Main2Activity.this,GuanActivity.class);
                    startActivity(intent);

                }

                if(i == 1){
                    //我的收藏
                    Toast.makeText(Main2Activity.this, "我的收藏", Toast.LENGTH_SHORT).show();

                }

                if(i == 2){
                    //搜索好友
                    Intent intent = new Intent(Main2Activity.this,SSActivity.class);
                    startActivity(intent);
                }

                if(i == 3){
                    //消息通知
                    Toast.makeText(Main2Activity.this, "消息通知", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //点击事件
        main2_lin1.setOnClickListener(this);
        main2_lin2.setOnClickListener(this);
        main2_lin3.setOnClickListener(this);
        main2_lin4.setOnClickListener(this);
        main2_xie.setOnClickListener(this);
        main2_touxiang.setOnClickListener(this);
        left_zuopin.setOnClickListener(this);
        left_shezhi.setOnClickListener(this);

        //默认是推荐
        main2_tuijian.setImageResource(R.mipmap.tuijian2);
        main2_tv_tuijian.setTextColor(Color.parseColor("#33ccff"));
        getSupportFragmentManager().beginTransaction().replace(R.id.main2_fg,new Fragment1()).commit();
        main2_head_tv.setText("推荐");

        //头像圆形
        Glide.with(this).load(R.mipmap.raw_1500033586)
                .bitmapTransform(new GlideCircleTransform(this))
                .into(left_touxiang);
        Glide.with(this).load(R.mipmap.raw_1500033586)
                .bitmapTransform(new GlideCircleTransform(this))
                .into(main2_touxiang);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_shezhi:
                Intent intent = new Intent(Main2Activity.this,SheZhiActivity.class);
                startActivity(intent);

                break;

            case R.id.left_zuopin:
                Intent intent2 = new Intent(Main2Activity.this,MasterActivity.class);
                startActivity(intent2);

                break;
            case R.id.main2_touxiang:
                //点击主页的头像
                drawer_layout.openDrawer(Gravity.LEFT);

                break;
            case R.id.main2_xie:
                Toast.makeText(this, "在另一个App里面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main2_lin1:
                //推荐
                main2_head_tv.setText("推荐");
                main2_tuijian.setImageResource(R.mipmap.tuijian2);
                main2_tv_tuijian.setTextColor(Color.parseColor("#33ccff"));
                getSupportFragmentManager().beginTransaction().replace(R.id.main2_fg,new Fragment1()).commit();

                main2_duanzi.setImageResource(R.mipmap.duanzi1);
                main2_tv_duanzi.setTextColor(Color.parseColor("#999999"));
                main2_shipin.setImageResource(R.mipmap.shipin1);
                main2_tv_shipin.setTextColor(Color.parseColor("#999999"));
                main2_faxian.setImageResource(R.mipmap.raw_xin2);
                main2_tv_faxian.setTextColor(Color.parseColor("#999999"));

                break;
            case R.id.main2_lin2:
                //段子
                main2_head_tv.setText("段子");
                main2_duanzi.setImageResource(R.mipmap.duanzi2);
                main2_tv_duanzi.setTextColor(Color.parseColor("#33ccff"));
                getSupportFragmentManager().beginTransaction().replace(R.id.main2_fg,new Fragment2()).commit();

                main2_tuijian.setImageResource(R.mipmap.tuijian1);
                main2_tv_tuijian.setTextColor(Color.parseColor("#999999"));
                main2_shipin.setImageResource(R.mipmap.shipin1);
                main2_tv_shipin.setTextColor(Color.parseColor("#999999"));
                main2_faxian.setImageResource(R.mipmap.raw_xin2);
                main2_tv_faxian.setTextColor(Color.parseColor("#999999"));

                break;
            case R.id.main2_lin3:
                //视频
                main2_head_tv.setText("视频");
                main2_shipin.setImageResource(R.mipmap.shipin2);
                main2_tv_shipin.setTextColor(Color.parseColor("#33ccff"));
                getSupportFragmentManager().beginTransaction().replace(R.id.main2_fg,new Fragment3()).commit();

                main2_duanzi.setImageResource(R.mipmap.duanzi1);
                main2_tv_duanzi.setTextColor(Color.parseColor("#999999"));
                main2_tuijian.setImageResource(R.mipmap.tuijian1);
                main2_tv_tuijian.setTextColor(Color.parseColor("#999999"));
                main2_faxian.setImageResource(R.mipmap.raw_xin2);
                main2_tv_faxian.setTextColor(Color.parseColor("#999999"));

                break;
            case R.id.main2_lin4:
                //发现
                main2_head_tv.setText("发现");
                main2_faxian.setImageResource(R.mipmap.raw_xin);
                main2_tv_faxian.setTextColor(Color.parseColor("#33ccff"));
                getSupportFragmentManager().beginTransaction().replace(R.id.main2_fg,new Fragment4()).commit();

                main2_duanzi.setImageResource(R.mipmap.duanzi1);
                main2_tv_duanzi.setTextColor(Color.parseColor("#999999"));
                main2_tuijian.setImageResource(R.mipmap.tuijian1);
                main2_tv_tuijian.setTextColor(Color.parseColor("#999999"));
                main2_shipin.setImageResource(R.mipmap.shipin1);
                main2_tv_shipin.setTextColor(Color.parseColor("#999999"));

                break;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void UserInfoSuccess(UserInfoBean value) {

        String nickname = value.data.nickname;
        String icon = value.data.icon;

        //昵称
        left_tv_nicheng.setText(nickname);
        //头像圆形
        Glide.with(this).load(icon)
                .bitmapTransform(new GlideCircleTransform(this))
                .into(left_touxiang);
        Glide.with(this).load(icon)
                .bitmapTransform(new GlideCircleTransform(this))
                .into(main2_touxiang);

    }

    @Override
    public void UserInfoFailure(String msg) {

    }
}
