package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.JokerBean;
import com.zxx.myapp3.model.JokerModel;
import com.zxx.myapp3.view.JokerView;

import javax.inject.Inject;

/**
 * 段子列表Presenter
 */

public class JokerPresenter implements JokerModel.JokerMessage {

    @Inject
    JokerModel jokerModel;
    JokerView jokerView;

    @Inject
    public JokerPresenter(JokerView jokerView) {
        this.jokerView = jokerView;
    }

    public void rele(String page){
        jokerModel.setJokerMessage(this);
        jokerModel.getJokerData(page);
    }


    @Override
    public void JokerSuccess(JokerBean value) {
        jokerView.JokerSuccess(value);
    }

    @Override
    public void JokerFailure(String msg) {
        jokerView.JokerFailure(msg);
    }
}
