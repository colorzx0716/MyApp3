package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.VideosBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 视频Model
 */

public class VideosModel {

    @Inject
    public VideosModel() {
    }

     public void getVideosData(String uid,String type,String page){

        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build().getMyQusetUtils().getVideos(uid,type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideosBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            videosMessage.videosSuccess(value);
                        }else{
                            videosMessage.videosFailure(value.msg);
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

     private VideosMessage videosMessage;

    public void setVideosMessage(VideosMessage videosMessage) {
        this.videosMessage = videosMessage;
    }

    public interface VideosMessage{
        void videosSuccess(VideosBean value);
        void videosFailure(String msg);
    }

}
