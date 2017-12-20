package com.zxx.myapp3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zxx.myapp3.R;
import com.zxx.myapp3.adapter.MyJokerAdapter;
import com.zxx.myapp3.dagger2.DaggerMyComponent;
import com.zxx.myapp3.dagger2.MyComponent;
import com.zxx.myapp3.dagger2.MyModule;
import com.zxx.myapp3.entity.JokerBean;
import com.zxx.myapp3.presenter.JokerPresenter;
import com.zxx.myapp3.view.JokerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 段子Fragment
 */

public class Fragment2 extends Fragment implements JokerView{


    private View view;
    private XRecyclerView fg2_xrv;
    private int page = 1;
    List<JokerBean.DataBean> list;

    @Inject
    JokerPresenter jokerPresenter;
    private MyJokerAdapter myJokerAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment2, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = new ArrayList<>();

        fg2_xrv = view.findViewById(R.id.fg2_xrv);

        MyComponent component = DaggerMyComponent.builder().myModule(new MyModule(this)).build();
        component.inject(this);

        jokerPresenter.rele(page+"");


        //加载刷新
        fg2_xrv.setLoadingMoreEnabled(true);
        fg2_xrv.setPullRefreshEnabled(true);


        linearLayoutManager = new LinearLayoutManager(getActivity());
        fg2_xrv.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void JokerSuccess(JokerBean value) {

        List<JokerBean.DataBean> data = value.data;

        //加载更多的监听器
        list.addAll(data);

        if(myJokerAdapter == null)
        {
            myJokerAdapter = new MyJokerAdapter(getActivity(),list);
            fg2_xrv.setAdapter(myJokerAdapter);

        }else
        {
            myJokerAdapter.notifyDataSetChanged();
        }

        fg2_xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                list.clear();
                jokerPresenter.rele(page+"");
                Toast.makeText(getActivity(), "刷新", Toast.LENGTH_SHORT).show();
                fg2_xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                jokerPresenter.rele(page+"");
                Toast.makeText(getActivity(), "加载", Toast.LENGTH_SHORT).show();
                fg2_xrv.loadMoreComplete();
            }
        });

    }

    @Override
    public void JokerFailure(String msg) {

    }
}
