package com.zxx.myapp3.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zxx.myapp3.R;
import com.zxx.myapp3.entity.JokerBean;
import com.zxx.myapp3.util.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * 段子列表的Adapter
 */

public class MyJokerAdapter extends XRecyclerView.Adapter<MyJokerAdapter.MyJokerViewHolder>{


    private final Context context;
    private final List<JokerBean.DataBean> data;

    public MyJokerAdapter(Context context, List<JokerBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyJokerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.joker_list_item, null);
        MyJokerViewHolder holder = new MyJokerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyJokerViewHolder holder, final int position) {

        String icon = data.get(position).user.icon;//头像
        String nickname = data.get(position).user.nickname;//昵称
        String createTime = data.get(position).createTime;
        String content = data.get(position).content;//内容

        //头像
        Glide.with(context).load(icon)
                .bitmapTransform(new GlideCircleTransform(context))
                .into(holder.joker_list_touxiang);

        holder.joker_list_nicheng.setText(nickname);
        holder.joker_list_data.setText(createTime);
        holder.joker_list_duanzi.setText(content);


        if(data.get(position).imgUrls != null){
            //============嵌套的Recyclerview
            String string = data.get(position).imgUrls.toString();
            String[] split = string.split("\\|");
            List<String> imgUrls = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                imgUrls.add(split[i]);
            }

            GridLayoutManager layoutManager = new GridLayoutManager(context,3);
            holder.joker_list_rv.setLayoutManager(layoutManager);

            MyFg2sAdapter myFg2sAdapter = new MyFg2sAdapter(context,imgUrls);
            holder.joker_list_rv.setAdapter(myFg2sAdapter);

            //==============
        }

        //头像点击事件
        holder.joker_list_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "MyFg2Adapter里面的uid"+data.get(position).uid, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "水波纹~~"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyJokerViewHolder extends XRecyclerView.ViewHolder{

        private final ImageView joker_list_touxiang;
        private final TextView joker_list_nicheng;
        private final TextView joker_list_duanzi;
        private final TextView joker_list_data;
        private final RecyclerView joker_list_rv;

        public MyJokerViewHolder(View itemView) {
            super(itemView);
            joker_list_touxiang = itemView.findViewById(R.id.joker_list_touxiang);
            joker_list_nicheng = itemView.findViewById(R.id.joker_list_nicheng);
            joker_list_data = itemView.findViewById(R.id.joker_list_data);
            joker_list_duanzi = itemView.findViewById(R.id.joker_list_duanzi);
            joker_list_rv = itemView.findViewById(R.id.joker_list_rv);
        }
    }


}
