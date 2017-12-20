package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.LoginBean;

/**
 * 登录的View
 */

public interface LoginView {
    void loginSuccess(LoginBean value);
    void loginFailue(String msg);
}
