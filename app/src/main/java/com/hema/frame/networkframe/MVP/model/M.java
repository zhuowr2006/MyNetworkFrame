package com.hema.frame.networkframe.MVP.model;

import com.hema.frame.networkframe.MVP.presenter.PMlistener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * m层数据处理
 * Created by WZG on 2016/12/26.
 */

public class M implements Mlistener, HttpOnNextListener {
    private PMlistener pVlistener;

    public M(PMlistener pVlistener) {
        this.pVlistener = pVlistener;
    }

    @Override
    public void startPost(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpManager manager = new HttpManager(this, rxAppCompatActivity);
        manager.doHttpDeal(baseApi);
    }

    @Override
    public void testDo(String s) {
        String msg = "M" + s;
        pVlistener.testPSuc(msg);
    }


    @Override
    public void onNext(String resulte, String mothead) {
        pVlistener.onNext(resulte, mothead);
    }

    @Override
    public void onError(ApiException e) {
        pVlistener.onError(e);
    }

}
