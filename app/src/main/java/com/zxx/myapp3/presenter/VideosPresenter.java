package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.VideosBean;
import com.zxx.myapp3.model.VideosModel;
import com.zxx.myapp3.view.VideosView;

import javax.inject.Inject;

/**
 * 视频Presenter
 */

public class VideosPresenter implements VideosModel.VideosMessage {

    @Inject
    VideosModel videosModel;
    VideosView videosView;

    @Inject
    public VideosPresenter(VideosView videosView) {
        this.videosView = videosView;
    }

    public void rele(String uid,String type,String page){
        videosModel.setVideosMessage(this);
        videosModel.getVideosData(uid, type, page);

    }

    @Override
    public void videosSuccess(VideosBean value) {
        videosView.videosSuccess(value);
    }

    @Override
    public void videosFailure(String msg) {
        videosView.videosFailure(msg);
    }
}
