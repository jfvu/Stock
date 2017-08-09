package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SingleTestActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_single)
    LinearLayout mLlStatusActivitySingle;
    @BindView(R.id.rl_return_activity_single)
    RelativeLayout mRlReturnActivitySingle;
    @BindView(R.id.tv_formula)
    TextView mTvFormula;
    @BindView(R.id.ll_reversal)
    LinearLayout mLlReversal;
    @BindView(R.id.ll_choose)
    LinearLayout mLlChoose;
    @BindView(R.id.btn_test)
    Button mBtnTest;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_test;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySingle;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.rl_return_activity_single, R.id.tv_formula, R.id.ll_reversal, R.id.ll_choose, R.id.btn_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_single:
                finish();
                break;
            case R.id.tv_formula:
                mIntent = new Intent(this,PreviewActivity.class);

                startActivity(mIntent);
                break;
            case R.id.ll_reversal:
                finish();
                break;
            case R.id.ll_choose:
                break;
            case R.id.btn_test:
                finish();
                break;
        }
    }
}
