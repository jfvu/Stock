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

public class CreateFormulaActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_createformula)
    LinearLayout mLlStatusActivityCreateformula;
    @BindView(R.id.img_return_activity_createformula)
    ImageView mImgReturnActivityCreateformula;
    @BindView(R.id.btn_next_activity_createformula)
    Button mBtnNextActivityCreateformula;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_formula;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCreateformula;
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

    @OnClick({R.id.img_return_activity_createformula, R.id.btn_next_activity_createformula})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_createformula:
                finish();
                break;
            case R.id.btn_next_activity_createformula:
                startActivity(new Intent(this,PreferencesActivity.class));
                break;
        }
    }
}
