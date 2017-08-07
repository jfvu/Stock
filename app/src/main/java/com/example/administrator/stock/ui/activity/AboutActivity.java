package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_about)
    LinearLayout mLlStatusActivityAbout;
    @BindView(R.id.img_return_activity_about)
    RelativeLayout mImgReturnActivityAbout;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAbout;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.img_return_activity_about)
    public void onViewClicked() {
        finish();
    }
}
