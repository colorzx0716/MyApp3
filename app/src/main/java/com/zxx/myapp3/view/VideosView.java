package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.VideosBean;

/**
 * 视频view
 */

public interface VideosView {

    void videosSuccess(VideosBean value);
    void videosFailure(String msg);

}
