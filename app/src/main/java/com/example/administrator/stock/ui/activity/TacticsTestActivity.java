package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class TacticsTestActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_tacticstest)
    LinearLayout mLlStatusActivityTacticstest;
    @BindView(R.id.img_return_activity_ticticstest)
    ImageView mImgReturnActivityTicticstest;
    @BindView(R.id.tv_save_activity_tacticstest)
    TextView mTvSaveActivityTacticstest;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tactics_test;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityTacticstest;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_ticticstest, R.id.tv_save_activity_tacticstest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_ticticstest:
                finish();
                break;
            case R.id.tv_save_activity_tacticstest:
                break;
        }
    }
}
