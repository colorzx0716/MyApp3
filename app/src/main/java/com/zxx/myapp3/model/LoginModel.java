package com.zxx.myapp3.model;

import com.zxx.myapp3.entity.LoginBean;
import com.zxx.myapp3.util.HttpUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 登录的model
 */

public class LoginModel {

    @Inject
    public LoginModel() {
    }

    public void getLoginData(String mobile, String password){
        new HttpUtils.Builder().
                addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils().getLogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        String code = value.code;
                        if(code.equals("0")){
                            loginMessage.loginSuccess(value);
                        }else{
                            loginMessage.loginFailue(value.msg);
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

    private LoginMessage loginMessage;

    public void setLoginMessage(LoginMessage loginMessage) {
        this.loginMessage = loginMessage;
    }

    public interface LoginMessage{
        void loginSuccess(LoginBean value);
        void loginFailue(String msg);
    }


}
