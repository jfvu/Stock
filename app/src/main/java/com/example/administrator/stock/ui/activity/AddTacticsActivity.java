package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTacticsActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_addtactics)
    LinearLayout mLlStatusActivityAddtactics;
    @BindView(R.id.img_return_activity_addtactics)
    RelativeLayout mImgReturnActivityAddtactics;
    @BindView(R.id.rl_name_activity_tactics)
    RelativeLayout mRlNameActivityTactics;
    @BindView(R.id.rl_appoint_activity_tactics)
    RelativeLayout mRlAppointActivityTactics;
    @BindView(R.id.rl_buy_activity_tactics)
    RelativeLayout mRlBuyActivityTactics;
    @BindView(R.id.rl_sell_activity_tactics)
    RelativeLayout mRlSellActivityTactics;
    @BindView(R.id.rl_stop_activity_tactics)
    RelativeLayout mRlStopActivityTactics;
    @BindView(R.id.rl_lucation_activity_tactics)
    RelativeLayout mRlLucationActivityTactics;
    @BindView(R.id.rl_price_activity_tactics)
    RelativeLayout mRlPriceActivityTactics;
    @BindView(R.id.btn_test_activity_tactics)
    Button mBtnTestActivityTactics;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_tactics;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAddtactics;
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

    @OnClick({R.id.img_return_activity_addtactics, R.id.rl_name_activity_tactics, R.id.rl_appoint_activity_tactics, R.id.rl_buy_activity_tactics, R.id.rl_sell_activity_tactics, R.id.rl_stop_activity_tactics, R.id.rl_lucation_activity_tactics, R.id.rl_price_activity_tactics, R.id.btn_test_activity_tactics})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_addtactics:
                finish();
                break;
            case R.id.rl_name_activity_tactics:
                break;
            case R.id.rl_appoint_activity_tactics:
                mIntent = new Intent(this,AppointActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_buy_activity_tactics:
                mIntent = new Intent(this,RuleActivity.class);
                mIntent.putExtra("RuleActivity","买入规则");
                startActivity(mIntent);
                break;
            case R.id.rl_sell_activity_tactics:
                mIntent = new Intent(this,RuleActivity.class);
                mIntent.putExtra("RuleActivity","卖出规则");
                startActivity(mIntent);
                break;
            case R.id.rl_stop_activity_tactics:
                mIntent = new Intent(this,StopActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_lucation_activity_tactics:
                mIntent = new Intent(this,ManageSiteActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_price_activity_tactics:
                break;
            case R.id.btn_test_activity_tactics:
                mIntent = new Intent(this,TacticsTestActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
