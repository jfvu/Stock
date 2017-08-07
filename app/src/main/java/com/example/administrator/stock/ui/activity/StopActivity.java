package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class StopActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_stop)
    LinearLayout mLlStatusActivityStop;
    @BindView(R.id.img_return_activity_stop)
    RelativeLayout mImgReturnActivityStop;
    @BindView(R.id.img_open1_activity_stop)
    ImageView mImgOpen1ActivityStop;
    @BindView(R.id.btn_change1_activity_stop)
    Button mBtnChange1ActivityStop;
    @BindView(R.id.img_open2_activity_stop)
    ImageView mImgOpen2ActivityStop;
    @BindView(R.id.btn_change2_activity_stop)
    Button mBtnChange2ActivityStop;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityStop;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_stop, R.id.img_open1_activity_stop, R.id.btn_change1_activity_stop, R.id.img_open2_activity_stop, R.id.btn_change2_activity_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_stop:
                finish();
                break;
            case R.id.img_open1_activity_stop:
                break;
            case R.id.btn_change1_activity_stop:
                break;
            case R.id.img_open2_activity_stop:
                break;
            case R.id.btn_change2_activity_stop:
                break;
        }
    }
}
