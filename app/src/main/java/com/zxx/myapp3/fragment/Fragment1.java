package com.zxx.myapp3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.zxx.myapp3.R;
import com.zxx.myapp3.adapter.MyVideosAdapter;
import com.zxx.myapp3.dagger2.DaggerMyComponent;
import com.zxx.myapp3.dagger2.MyComponent;
import com.zxx.myapp3.dagger2.MyModule;
import com.zxx.myapp3.entity.AdBean;
import com.zxx.myapp3.entity.VideosBean;
import com.zxx.myapp3.presenter.AdPresenteer;
import com.zxx.myapp3.presenter.VideosPresenter;
import com.zxx.myapp3.util.ShareprefrensUtils;
import com.zxx.myapp3.view.AdView;
import com.zxx.myapp3.view.VideosView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 推荐Fragment
 */

public class Fragment1 extends Fragment implements AdView,VideosView{

    private View view;
    private XBanner fg1_head_xbanner;
    private XRecyclerView fg1_xrv;
    private List<VideosBean.DataBean> list;

    private List<String> imgs;
    private List<String> titles;

    private int page=1;

    @Inject
    AdPresenteer adPresenteer;
    @Inject
    VideosPresenter videosPresenter;
    private MyVideosAdapter myVideosAdapter;
    private String uid;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment1, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        list = new ArrayList<>();
        MyComponent component = DaggerMyComponent.builder().myModule(new MyModule(this,this)).build();
        component.inject(this);

        uid = (String) ShareprefrensUtils.get(getActivity(), "uid", "");

        adPresenteer.rele();
        videosPresenter.rele(uid,"1",page+"");

    }

    private void initView() {

        //Xbanner控件
        View view2 = View.inflate(getActivity(), R.layout.head_item, null);
        fg1_head_xbanner = view2.findViewById(R.id.fg1_head_xbanner);

        fg1_xrv = view.findViewById(R.id.fg1_xrv);

        //加载刷新
        fg1_xrv.setLoadingMoreEnabled(true);
        fg1_xrv.setPullRefreshEnabled(true);

        //添加头部
        fg1_xrv.addHeaderView(view2);

    }

    @Override
    public void onResume() {
        super.onResume();
        fg1_head_xbanner.stopAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        fg1_head_xbanner.stopAutoPlay();
    }


    @Override
    public void AdSuccess(AdBean value) {
        //添加数据
        imgs = new ArrayList<>();
        titles = new ArrayList<>();

        List<AdBean.DataBean> data = value.data;
        for (int i = 0; i < data.size(); i++) {
            imgs.add(data.get(i).icon);
            titles.add("");
        }

        //绑定数据
        fg1_head_xbanner.setData(imgs,titles);
        //Xbanner适配数据
        fg1_head_xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getContext()).load(imgs.get(position)).into((ImageView) view);
            }
        });

        // 设置XBanner的页面切换特效
        fg1_head_xbanner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        fg1_head_xbanner.setPageChangeDuration(2000);

    }

    @Override
    public void AdFailure(String msg) {

    }

    @Override
    public void videosSuccess(VideosBean value) {
        List<VideosBean.DataBean> data = value.data;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fg1_xrv.setLayoutManager(linearLayoutManager);
        myVideosAdapter = new MyVideosAdapter(getActivity(),data);
        fg1_xrv.setAdapter(myVideosAdapter);

        list.addAll(data);

        if(myVideosAdapter == null)
        {
            myVideosAdapter = new MyVideosAdapter(getActivity(),list);
            fg1_xrv.setAdapter(myVideosAdapter);

        }else
        {
            myVideosAdapter.notifyDataSetChanged();
        }

        fg1_xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                list.clear();
                videosPresenter.rele(uid,"1",page+"");
                Toast.makeText(getContext(), "刷新", Toast.LENGTH_SHORT).show();
                fg1_xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                videosPresenter.rele(uid,"1",page+"");
                Toast.makeText(getActivity(), "加载", Toast.LENGTH_SHORT).show();
                fg1_xrv.loadMoreComplete();
            }
        });

    }

    @Override
    public void videosFailure(String msg) {

    }
}
