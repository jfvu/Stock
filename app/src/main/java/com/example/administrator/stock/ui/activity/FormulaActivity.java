package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormulaActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_formula)
    LinearLayout mLlStatusActivityFormula;
    @BindView(R.id.img_return_activity_formula)
    ImageView mImgReturnActivityFormula;
    @BindView(R.id.tv_edit_activity_formula)
    TextView mTvEditActivityFormula;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_formula;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityFormula;
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

    @OnClick({R.id.img_return_activity_formula, R.id.tv_edit_activity_formula})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_formula:
                finish();
                break;
            case R.id.tv_edit_activity_formula:
                break;
        }
    }
}
