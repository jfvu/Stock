package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewDetailsActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_newdetails)
    LinearLayout mLlStatusActivityNewdetails;
    @BindView(R.id.img_return_activity_newdetails)
    ImageView mImgReturnActivityNewdetails;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_details;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityNewdetails;
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

    @OnClick(R.id.img_return_activity_newdetails)
    public void onViewClicked() {
        finish();
    }
}
