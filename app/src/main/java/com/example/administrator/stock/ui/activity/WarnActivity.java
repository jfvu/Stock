package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class WarnActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_warn)
    LinearLayout mLlStatusActivityWarn;
    @BindView(R.id.img_return_activity_warn)
    RelativeLayout mImgReturnActivityWarn;
    @BindView(R.id.ll_formula)
    LinearLayout mLlFormula;
    @BindView(R.id.ll_tendency)
    LinearLayout mLlTendency;
    @BindView(R.id.ll_condition)
    LinearLayout mLlCondition;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_warn;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityWarn;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_warn, R.id.ll_formula, R.id.ll_tendency, R.id.ll_condition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_warn:
                finish();
                break;
            case R.id.ll_formula:
                mIntent = new Intent(this,FormulaActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_tendency:
                mIntent = new Intent(this,TendencyActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_condition:
                mIntent = new Intent(this,Condition1Activity.class);
                startActivity(mIntent);
                break;
        }
    }
}
