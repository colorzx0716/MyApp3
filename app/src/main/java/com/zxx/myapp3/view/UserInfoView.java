package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.UserInfoBean;

/**
 * 用户信息View
 */

public interface UserInfoView {
    void UserInfoSuccess(UserInfoBean value);
    void UserInfoFailure(String msg);

}
