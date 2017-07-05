package com.hema.frame.networkframe.MVP.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hema.frame.networkframe.MVP.presenter.P;
import com.hema.frame.networkframe.MVP.presenter.Plistener;
import com.hema.frame.networkframe.R;
import com.hema.frame.networkframe.base.BaseActivity;
import com.hema.frame.networkframe.entity.api.SubjectPostApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements Vlistener {

    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    private Plistener plistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        plistener = new P(this);

    }

    @Override
    public void onTestNext(String msg) {
        tvTest.setText("测试返回数据了：" + msg);
    }

    @Override
    public void showProg() {
        showP();
    }

    @Override
    public void dismissProg() {
        dismissP();
    }

    @Override
    public void onNext(String s, String m) {
        tvMsg.setText("返回数据:" + s);
    }

    @Override
    public void onError(ApiException e) {
        tvMsg.setText("错误信息:" + e.getMessage() + "------" + e.getCode());
    }

    @OnClick({R.id.tv_test, R.id.tv_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                plistener.doTest("1");
                break;
            case R.id.tv_msg:
                SubjectPostApi postEntity = new SubjectPostApi();
                postEntity.setAll(true);
                plistener.startPost(MainActivity.this, postEntity);
                break;
        }
    }
}
