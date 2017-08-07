package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Condition1Activity extends BaseActivity {


    @BindView(R.id.ll_status_activity_condition)
    LinearLayout mLlStatusActivityCondition;
    @BindView(R.id.img_return_activity_condition)
    RelativeLayout mImgReturnActivityCondition;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_condition1;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCondition;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_condition)
    public void onViewClicked() {
        finish();
    }
}
