package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.FollowUsersBean;
import com.zxx.myapp3.model.FollowUsersModel;
import com.zxx.myapp3.view.FollowUsersView;

import javax.inject.Inject;

/**
 * 获取关注列表Presenter
 */

public class FollowUsersPresenter implements FollowUsersModel.FollowUserMessage {

    @Inject
    FollowUsersModel followUsersModel;
    FollowUsersView followUsersView;

    @Inject
    public FollowUsersPresenter(FollowUsersView followUsersView) {
        this.followUsersView = followUsersView;
    }

    public void rele(String uid){
        followUsersModel.setFollowUserMessage(this);
        followUsersModel.getFollowUsersData(uid);
    }


    @Override
    public void FollowUserSuccess(FollowUsersBean value) {
        followUsersView.FollowUserSuccess(value);

    }

    @Override
    public void FolloeUserFailure(String msg) {
        followUsersView.FolloeUserFailure(msg);
    }
}
