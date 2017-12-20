package com.zxx.myapp3.presenter;

import com.zxx.myapp3.entity.AdBean;
import com.zxx.myapp3.model.AdModel;
import com.zxx.myapp3.view.AdView;

import javax.inject.Inject;

/**
 *广告的Presenter
 */

public class AdPresenteer implements AdModel.AdMessage {

    @Inject
    AdModel adModel;
    AdView adView;

    @Inject
    public AdPresenteer(AdView adView) {
        this.adView = adView;
    }

    public void rele(){
        adModel.setAdMessage(this);
        adModel.getAdData();
    }


    @Override
    public void AdSuccess(AdBean value) {
        adView.AdSuccess(value);
    }

    @Override
    public void AdFailure(String msg) {
       adView.AdFailure(msg);
    }
}
