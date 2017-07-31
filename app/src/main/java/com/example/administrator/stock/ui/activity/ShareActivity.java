package com.example.administrator.stock.ui.activity;

import android.content.Intent;
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

public class ShareActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_share)
    LinearLayout mLlStatusActivityShare;
    @BindView(R.id.img_return_activity_share)
    ImageView mImgReturnActivityShare;
    @BindView(R.id.btn_share_activity_share)
    Button mBtnShareActivityShare;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityShare;
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

    @OnClick({R.id.img_return_activity_share, R.id.btn_share_activity_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_share:
                finish();
                break;
            case R.id.btn_share_activity_share:
                startActivity(new Intent(this,InviteActivity.class));
                break;
        }
    }
}
