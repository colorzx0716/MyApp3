package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.LoginBean;
import com.zxx.myapp3.model.LoginModel;
import com.zxx.myapp3.view.LoginView;

import javax.inject.Inject;

/**
 * 登录Presenter
 */

public class LoginPresenter implements LoginModel.LoginMessage {

    @Inject
    LoginModel loginModel;
    LoginView loginView;

    @Inject
    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    //p关联m
    public void relevance(String name,String pwd){
        loginModel.setLoginMessage(this);
        loginModel.getLoginData(name, pwd);
    }


    @Override
    public void loginSuccess(LoginBean value) {
        loginView.loginSuccess(value);
    }

    @Override
    public void loginFailue(String msg) {
        loginView.loginFailue(msg);
    }
}
