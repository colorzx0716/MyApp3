package com.zxx.myapp3.adapter;

/**
 * Created by 张肖肖 on 2017/12/19.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zxx.myapp3.R;
import com.zxx.myapp3.entity.SearchBean;
import com.zxx.myapp3.util.GlideCircleTransform;

import java.util.List;

/**
 * 搜索好友Adapter
 */

public class MySSAdapter extends RecyclerView.Adapter<MySSAdapter.MySSViewHolder>{


    private final Context context;
    private final List<SearchBean.DataBean> data;

    public MySSAdapter(Context context, List<SearchBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MySSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.ss_list_item, null);
        MySSViewHolder holder = new MySSViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MySSViewHolder holder, int position) {
        String nickname = data.get(position).nickname;
        String icon = data.get(position).icon;

        holder.ss_list_nicheng.setText(nickname);

        Glide.with(context).load(icon).bitmapTransform(new GlideCircleTransform(context)).into(holder.ss_list_touxiang);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MySSViewHolder extends RecyclerView.ViewHolder{

        private final TextView ss_list_nicheng;
        private final ImageView ss_list_touxiang;

        public MySSViewHolder(View itemView) {
            super(itemView);
            ss_list_nicheng = itemView.findViewById(R.id.ss_list_nicheng);
            ss_list_touxiang = itemView.findViewById(R.id.ss_list_touxiang);

        }
    }

}

