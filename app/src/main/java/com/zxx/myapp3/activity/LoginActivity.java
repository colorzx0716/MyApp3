package com.zxx.myapp3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zxx.myapp3.R;
import com.zxx.myapp3.dagger2.DaggerMyComponent;
import com.zxx.myapp3.dagger2.MyComponent;
import com.zxx.myapp3.dagger2.MyModule;
import com.zxx.myapp3.entity.LoginBean;
import com.zxx.myapp3.presenter.LoginPresenter;
import com.zxx.myapp3.util.ShareprefrensUtils;
import com.zxx.myapp3.view.LoginView;

import javax.inject.Inject;

import scut.carson_ho.diy_view.SuperEditText;

/**
 * 登录页面
 */
public class LoginActivity extends AppCompatActivity implements LoginView{

    private Button super_btn;
    private SuperEditText super_pwd;
    private SuperEditText super_name;
    private SharedPreferences sp;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        sp = getSharedPreferences("sp", MODE_PRIVATE);
        initView();

        //获取桥梁
        MyComponent component = DaggerMyComponent.builder().myModule(new MyModule(this)).build();
        component.inject(this);

        super_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变sp的值
                sp.edit().putBoolean("isfirst",false).commit();

                String name = super_name.getText().toString();
                String pwd = super_pwd.getText().toString();
                loginPresenter.relevance(name,pwd);

            }
        });

    }

    //控件初始化
    private void initView() {
        //手机号码
        super_name = findViewById(R.id.super_name);
        //密码
        super_pwd = findViewById(R.id.super_pwd);
        //按钮
        super_btn = findViewById(R.id.super_btn);

    }


    @Override
    public void loginSuccess(LoginBean value) {

        //获取数据
        Toast.makeText(this, value.msg, Toast.LENGTH_SHORT).show();
        String nickname = value.data.nickname;
        System.out.println("=====nickname===="+nickname);

        ShareprefrensUtils.put(this,"uid",value.data.uid+"");
        ShareprefrensUtils.put(this,"token",value.data.token+"");

        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isfirst",true).commit();//提交

        //跳转页面
        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_to_top_in, R.anim.bottom_to_top_out);
        finish();

    }

    @Override
    public void loginFailue(String msg) {

    }
}
