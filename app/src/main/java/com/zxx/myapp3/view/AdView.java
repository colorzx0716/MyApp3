package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.AdBean;

/**
 * 广告的View
 */

public interface AdView {

    void AdSuccess(AdBean value);
    void AdFailure(String msg);

}
