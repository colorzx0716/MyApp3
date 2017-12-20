package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.JokerBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 段子列表Model
 */

public class JokerModel {

    @Inject
    public JokerModel() {
    }

    public void getJokerData(String page){
        new HttpUtils.Builder().addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils()
                .getUserJokes(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokerBean value) {

                        String code = value.code;
                        if(code.equals("0")){
                            jokerMessage.JokerSuccess(value);
                        }else{
                            jokerMessage.JokerFailure(value.msg);
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

    private JokerMessage jokerMessage;

    public void setJokerMessage(JokerMessage jokerMessage) {
        this.jokerMessage = jokerMessage;
    }

    public interface JokerMessage{
        void JokerSuccess(JokerBean value);
        void JokerFailure(String msg);
    }

}
