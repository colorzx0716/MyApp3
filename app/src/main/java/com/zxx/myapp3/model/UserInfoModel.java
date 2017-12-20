package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.UserInfoBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 用户信息Model
 */

public class UserInfoModel {

    @Inject
    public UserInfoModel() {
    }

    public void getUserInfoData(String uid){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build().getMyQusetUtils().getUserInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInfoBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            userInfoMessage.UserInfoSuccess(value);
                        }else{
                            userInfoMessage.UserInfoFailure(value.msg);
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

    private UserInfoMessage userInfoMessage;

    public void setUserInfoMessage(UserInfoMessage userInfoMessage) {
        this.userInfoMessage = userInfoMessage;
    }

    public interface UserInfoMessage{
        void UserInfoSuccess(UserInfoBean value);
        void UserInfoFailure(String msg);
    }
}
