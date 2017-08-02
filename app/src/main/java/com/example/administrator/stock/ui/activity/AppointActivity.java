package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppointActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_appoint)
    LinearLayout mLlStatusActivityAppoint;
    @BindView(R.id.img_return_activity_appoint)
    ImageView mImgReturnActivityAppoint;
    @BindView(R.id.img_open1_activity_appoint)
    ImageView mImgOpen1ActivityAppoint;
    @BindView(R.id.btn_change1_activity_appoint)
    Button mBtnChange1ActivityAppoint;
    @BindView(R.id.img_open2_activity_appoint)
    ImageView mImgOpen2ActivityAppoint;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appoint;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAppoint;
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

    @OnClick({R.id.img_return_activity_appoint, R.id.img_open1_activity_appoint, R.id.btn_change1_activity_appoint, R.id.img_open2_activity_appoint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_appoint:
                finish();
                break;
            case R.id.img_open1_activity_appoint:
                break;
            case R.id.btn_change1_activity_appoint:
                break;
            case R.id.img_open2_activity_appoint:
                break;
        }
    }
}
