package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.AdBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 广告的Model
 */

public class AdModel {

    @Inject
    public AdModel() {
    }

    public void getAdData(){
        new HttpUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .build().getMyQusetUtils().getAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            adMessage.AdSuccess(value);
                        }else{
                            adMessage.AdFailure(value.msg);
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

    private AdMessage adMessage;

    public void setAdMessage(AdMessage adMessage) {
        this.adMessage = adMessage;
    }

    public interface AdMessage{
        void AdSuccess(AdBean value);
        void AdFailure(String msg);
    }

}
