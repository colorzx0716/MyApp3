package com.zxx.myapp3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zxx.myapp3.R;
import com.zxx.myapp3.entity.FollowUsersBean;
import com.zxx.myapp3.util.GlideCircleTransform;

import java.util.List;

/**
 * 关注列表Adapter
 */

public class MyGuanAdapter extends RecyclerView.Adapter<MyGuanAdapter.MyGuanViewHolder>{


    private final Context context;
    private final List<FollowUsersBean.DataBean> data;

    public MyGuanAdapter(Context context, List<FollowUsersBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyGuanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.guan_list_item, null);
        MyGuanViewHolder holder = new MyGuanViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyGuanViewHolder holder, int position) {

        String nickname = data.get(position).nickname;
        String icon = data.get(position).icon;

        holder.guan_list_nicheng.setText(nickname);
        Glide.with(context).load(icon).bitmapTransform(new GlideCircleTransform(context))
                .into(holder.guan_list_touxiang);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyGuanViewHolder extends RecyclerView.ViewHolder{

        private final TextView guan_list_nicheng;
        private final ImageView guan_list_touxiang;
        private final ImageView guan_list_qu;

        public MyGuanViewHolder(View itemView) {
            super(itemView);
            guan_list_nicheng = itemView.findViewById(R.id.guan_list_nicheng);
            guan_list_touxiang = itemView.findViewById(R.id.guan_list_touxiang);
            guan_list_qu = itemView.findViewById(R.id.guan_list_qu);
        }
    }


}
