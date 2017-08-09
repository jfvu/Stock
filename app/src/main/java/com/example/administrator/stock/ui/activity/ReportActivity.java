package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ReportActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_report)
    LinearLayout mLlStatusActivityReport;
    @BindView(R.id.rl_return_activity_report)
    RelativeLayout mRlReturnActivityReport;
    @BindView(R.id.tv_formula)
    TextView mTvFormula;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_report;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityReport;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.rl_return_activity_report, R.id.tv_formula})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_report:
                finish();
                break;
            case R.id.tv_formula:
                startActivity(new Intent(this,PreviewActivity.class));
                break;
        }
    }
}
