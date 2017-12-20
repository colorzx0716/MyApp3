package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.FollowUsersBean;

/**
 * 获取关注列表View
 */

public interface FollowUsersView {

    void FollowUserSuccess(FollowUsersBean value);
    void FolloeUserFailure(String msg);

}
