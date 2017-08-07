package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchExplain2Activity extends BaseActivity {


    @BindView(R.id.ll_status_activity_matchexplain2)
    LinearLayout mLlStatusActivityMatchexplain2;
    @BindView(R.id.img_return_activity_matchexplain2)
    RelativeLayout mImgReturnActivityMatchexplain2;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_explain2;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMatchexplain2;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_matchexplain2)
    public void onViewClicked() {
        finish();
    }
}
