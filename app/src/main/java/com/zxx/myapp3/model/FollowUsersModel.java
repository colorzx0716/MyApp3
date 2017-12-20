package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.FollowUsersBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 获取关注列表Model
 */

public class FollowUsersModel {

    @Inject
    public FollowUsersModel() {
    }

    public void getFollowUsersData(String uid){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build().getMyQusetUtils().getFollowUsers(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FollowUsersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowUsersBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            followUserMessage.FollowUserSuccess(value);
                        }else{
                            followUserMessage.FolloeUserFailure(value.msg);
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

    private FollowUserMessage followUserMessage;

    public void setFollowUserMessage(FollowUserMessage followUserMessage) {
        this.followUserMessage = followUserMessage;
    }

    public interface FollowUserMessage{
        void FollowUserSuccess(FollowUsersBean value);
        void FolloeUserFailure(String msg);
    }



}
