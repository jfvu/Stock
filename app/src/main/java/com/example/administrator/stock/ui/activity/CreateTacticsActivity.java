package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateTacticsActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_createtactics)
    LinearLayout mLlStatusActivityCreatetactics;
    @BindView(R.id.img_return_activity_createtactics)
    RelativeLayout mImgReturnActivityCreatetactics;
    @BindView(R.id.tv_create)
    TextView mTvCreate;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_tactics;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCreatetactics;
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

    @OnClick({R.id.img_return_activity_createtactics, R.id.tv_create})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_createtactics:
                finish();
                break;
            case R.id.tv_create:
                finish();
                break;
        }
    }
}
