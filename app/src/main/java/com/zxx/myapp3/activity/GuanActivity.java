package com.zxx.myapp3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxx.myapp3.R;
import com.zxx.myapp3.adapter.MyGuanAdapter;
import com.zxx.myapp3.dagger2.DaggerMyComponent;
import com.zxx.myapp3.dagger2.MyComponent;
import com.zxx.myapp3.dagger2.MyModule;
import com.zxx.myapp3.entity.FollowUsersBean;
import com.zxx.myapp3.presenter.FollowUsersPresenter;
import com.zxx.myapp3.util.ShareprefrensUtils;
import com.zxx.myapp3.view.FollowUsersView;

import java.util.List;

import javax.inject.Inject;

/**
 * 关注列表
 */
public class GuanActivity extends AppCompatActivity implements FollowUsersView{

    @Inject
    FollowUsersPresenter followUsersPresenter;
    private ImageView guan_img;
    private TextView guan_remen;
    private RecyclerView guan_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guan);
        //手动隐藏标题
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initView();

        MyComponent component = DaggerMyComponent.builder().myModule(new MyModule(this)).build();
        component.inject(this);

        String uid = (String) ShareprefrensUtils.get(this, "uid", "");

        followUsersPresenter.rele(uid);


    }

    private void initView() {
        guan_img = findViewById(R.id.guan_img);
        guan_remen = findViewById(R.id.guan_remen);
        guan_rv = findViewById(R.id.guan_rv);

        guan_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//返回
            }
        });

    }

    @Override
    public void FollowUserSuccess(FollowUsersBean value) {

        List<FollowUsersBean.DataBean> data = value.data;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        guan_rv.setLayoutManager(linearLayoutManager);

        MyGuanAdapter myGuanAdapter = new MyGuanAdapter(this,data);
        guan_rv.setAdapter(myGuanAdapter);


    }

    @Override
    public void FolloeUserFailure(String msg) {

    }
}
