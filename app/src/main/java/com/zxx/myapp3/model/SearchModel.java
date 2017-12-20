package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.SearchBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 搜索好友Model
 */

public class SearchModel {

    @Inject
    public SearchModel() {
    }

    public void getSearchData(String keywords,String page){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build().getMyQusetUtils().getsearch(keywords, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean value) {

                        String code = value.code;
                        if(code.equals("0")){
                            searchMessage.searchSuccess(value);
                        }else{
                            searchMessage.searchFailure(value.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private SearchMessage searchMessage;

    public void setSearchMessage(SearchMessage searchMessage) {
        this.searchMessage = searchMessage;
    }

    public interface SearchMessage{
        void searchSuccess(SearchBean value);
        void searchFailure(String msg);
    }


}
