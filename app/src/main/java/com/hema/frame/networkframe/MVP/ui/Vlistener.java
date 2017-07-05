package com.hema.frame.networkframe.MVP.ui;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * Created by WZG on 2016/12/26.
 */
/*
* View层的回调接口，给P层使用，activity会去实现它,
* */
public interface Vlistener {

    void onTestNext(String msg);

    void showProg();

    void dismissProg();

    void onNext(String s, String m);

    void  onError(ApiException e);

}
