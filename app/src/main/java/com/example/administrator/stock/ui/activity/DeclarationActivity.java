package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class DeclarationActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_declaration)
    LinearLayout mLlStatusActivityDeclaration;
    @BindView(R.id.img_return_activity_declaration)
    RelativeLayout mImgReturnActivityDeclaration;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_declaration;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityDeclaration;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_declaration)
    public void onViewClicked() {
        finish();
    }
}
