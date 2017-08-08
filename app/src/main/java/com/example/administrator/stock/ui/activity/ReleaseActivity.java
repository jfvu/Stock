package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ReleaseActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_release)
    LinearLayout mLlStatusActivityRelease;
    @BindView(R.id.rl_return_activity_release)
    RelativeLayout mRlReturnActivityRelease;
    @BindView(R.id.ll_versions)
    LinearLayout mLlVersions;
    @BindView(R.id.ll_choose)
    LinearLayout mLlChoose;
    @BindView(R.id.ll_begin)
    LinearLayout mLlBegin;
    @BindView(R.id.ll_over)
    LinearLayout mLlOver;
    @BindView(R.id.ll_price)
    LinearLayout mLlPrice;
    @BindView(R.id.ll_single)
    LinearLayout mLlSingle;
    @BindView(R.id.ll_overall)
    LinearLayout mLlOverall;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityRelease;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.rl_return_activity_release, R.id.ll_versions, R.id.ll_choose, R.id.ll_begin, R.id.ll_over, R.id.ll_price, R.id.ll_single, R.id.ll_overall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_release:
                finish();
                break;
            case R.id.ll_versions:
                break;
            case R.id.ll_choose:
                break;
            case R.id.ll_begin:
                break;
            case R.id.ll_over:
                break;
            case R.id.ll_price:
                break;
            case R.id.ll_single:
                mIntent = new Intent(this,SingleTestActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_overall:
                mIntent = new Intent(this,OverallTestActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
