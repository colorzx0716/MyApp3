package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.JokerBean;

/**
 * 段子列表View
 */

public interface JokerView {

    void JokerSuccess(JokerBean value);
    void JokerFailure(String msg);
}
