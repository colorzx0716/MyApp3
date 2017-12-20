package com.zxx.myapp3.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zxx.myapp3.R;
import com.zxx.myapp3.entity.VideosBean;
import com.zxx.myapp3.util.GlideCircleTransform;

import java.util.List;

/**
 * 视频的Adapter
 */

public class MyVideosAdapter extends XRecyclerView.Adapter<MyVideosAdapter.MyVideosViewHolder>{


    private final Context context;
    private final List<VideosBean.DataBean> data;

    public MyVideosAdapter(Context context, List<VideosBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyVideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.videos_list_item, null);
        MyVideosViewHolder holder = new MyVideosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyVideosViewHolder holder, int position) {

        String videoUrl = data.get(position).videoUrl;//视频地址
        String icon = data.get(position).user.icon;//封面
        //昵称
        Object nickname = data.get(position).user.nickname;
        final String cover = data.get(position).cover;//封面

        View player = View.inflate(context, R.layout.simple_player_view_player, holder.videos_list_player);
        String replace = videoUrl.replace("https://www.zhaoapi.cn","http://120.27.23.105");

        PlayerView playerView = new PlayerView((Activity) context,player)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(replace)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        //视频加载之前显示缩略图
                        Glide.with(context).load(cover).into(ivThumbnail);
                    }
                })
                .startPlay();

        //头像
        if(icon != null){
          Glide.with(context).load(icon)
                  .bitmapTransform(new GlideCircleTransform(context))
                  .into(holder.videos_touxiang);
        }
        if(nickname != null){
            holder.videos_list_nicheng.setText((CharSequence) nickname);
        }

        //日期
        String createTime = data.get(position).createTime;
        if(createTime != null){
            holder.fg11_list_date.setText(createTime);
        }

        //描述
        String workDesc = data.get(position).workDesc;
        if(workDesc != null){
            holder.videos_list_des.setText(workDesc);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyVideosViewHolder extends XRecyclerView.ViewHolder{

        private final ImageView videos_touxiang;
        private final TextView videos_list_nicheng;
        private final TextView fg11_list_date;
        private final TextView videos_list_des;
        private final RelativeLayout videos_list_player;

        public MyVideosViewHolder(View itemView) {
            super(itemView);
            videos_touxiang = itemView.findViewById(R.id.videos_touxiang);
            videos_list_nicheng = itemView.findViewById(R.id.videos_list_nicheng);
            fg11_list_date = itemView.findViewById(R.id.fg11_list_date);
            videos_list_des = itemView.findViewById(R.id.videos_list_des);
            videos_list_player = itemView.findViewById(R.id.videos_list_player);

        }
    }

}
