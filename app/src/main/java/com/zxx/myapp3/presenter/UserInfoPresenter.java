package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.UserInfoBean;
import com.zxx.myapp3.model.UserInfoModel;
import com.zxx.myapp3.view.UserInfoView;

import javax.inject.Inject;

/**
 * 用户信息Presenter
 */

public class UserInfoPresenter implements UserInfoModel.UserInfoMessage {

    @Inject
    UserInfoModel userInfoModel;
    UserInfoView userInfoView;

    @Inject
    public UserInfoPresenter(UserInfoView userInfoView) {
        this.userInfoView = userInfoView;
    }

    public void rele(String uid){
        userInfoModel.setUserInfoMessage(this);
        userInfoModel.getUserInfoData(uid);
    }

    @Override
    public void UserInfoSuccess(UserInfoBean value) {
        userInfoView.UserInfoSuccess(value);
    }

    @Override
    public void UserInfoFailure(String msg) {
        userInfoView.UserInfoFailure(msg);
    }
}
