package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RuleActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_rule)
    LinearLayout mLlStatusActivityRule;
    @BindView(R.id.img_return_activity_rule)
    ImageView mImgReturnActivityRule;
    @BindView(R.id.tv_title_center_activity_rule)
    TextView mTvTitleCenterActivityRule;
    @BindView(R.id.rl_index_activity_rule)
    RelativeLayout mRlIndexActivityRule;
    @BindView(R.id.rl_base_activity_rule)
    RelativeLayout mRlBaseActivityRule;
    @BindView(R.id.rl_bulid_activity_rule)
    RelativeLayout mRlBulidActivityRule;
    @BindView(R.id.img_open1_activity_rule)
    ImageView mImgOpen1ActivityRule;
    @BindView(R.id.btn_change_activity_rule)
    Button mBtnChangeActivityRule;
    @BindView(R.id.img_open2_activity_rule)
    ImageView mImgOpen2ActivityRule;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mIntent = getIntent();
        String title = mIntent.getStringExtra("RuleActivity");
        mTvTitleCenterActivityRule.setText(title);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rule;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityRule;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_rule, R.id.rl_index_activity_rule, R.id.rl_base_activity_rule, R.id.rl_bulid_activity_rule, R.id.img_open1_activity_rule, R.id.btn_change_activity_rule, R.id.img_open2_activity_rule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_rule:
                finish();
                break;
            case R.id.rl_index_activity_rule:
                break;
            case R.id.rl_base_activity_rule:
                break;
            case R.id.rl_bulid_activity_rule:
                break;
            case R.id.img_open1_activity_rule:
                break;
            case R.id.btn_change_activity_rule:
                break;
            case R.id.img_open2_activity_rule:
                break;
        }
    }
}
