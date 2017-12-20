package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.SearchBean;
import com.zxx.myapp3.model.SearchModel;
import com.zxx.myapp3.view.SearchView;

import javax.inject.Inject;

/**
 * 搜索好友的Presenter
 */

public class SearchPresenter implements SearchModel.SearchMessage {

    @Inject
    SearchModel searchModel;
    SearchView searchView;

    @Inject
    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
    }

    public void rele(String keywords,String page){
        searchModel.setSearchMessage(this);
        searchModel.getSearchData(keywords, page);

    }

    @Override
    public void searchSuccess(SearchBean value) {
        searchView.searchSuccess(value);
    }

    @Override
    public void searchFailure(String msg) {
        searchView.searchFailure(msg);
    }
}
