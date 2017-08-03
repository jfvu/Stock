package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class GroupActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_group)
    LinearLayout mLlStatusActivityGroup;
    @BindView(R.id.img_return_activity_group)
    ImageView mImgReturnActivityGroup;
    @BindView(R.id.ll_scope)
    LinearLayout mLlScope;
    @BindView(R.id.ll_condition)
    LinearLayout mLlCondition;
    @BindView(R.id.ll_rule)
    LinearLayout mLlRule;
    @BindView(R.id.btn_entity)
    Button mBtnEntity;
    @BindView(R.id.btn_all)
    Button mBtnAll;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_group;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityGroup;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_group, R.id.ll_scope, R.id.ll_condition, R.id.ll_rule, R.id.btn_entity, R.id.btn_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_group:
                finish();
                break;
            case R.id.ll_scope:
                break;
            case R.id.ll_condition:
                break;
            case R.id.ll_rule:

                break;
            case R.id.btn_entity:
                mIntent = new Intent(GroupActivity.this,ConditionActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_all:
                mIntent = new Intent(GroupActivity.this,ConditionActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
