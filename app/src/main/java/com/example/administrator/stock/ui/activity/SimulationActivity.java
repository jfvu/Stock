package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimulationActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_simulation)
    LinearLayout mLlStatusActivitySimulation;
    @BindView(R.id.img_return_activity_simulation)
    ImageView mImgReturnActivitySimulation;
    @BindView(R.id.img_refresh_activity_simulation)
    ImageView mImgRefreshActivitySimulation;
    @BindView(R.id.rl_account_activity_simulation)
    RelativeLayout mRlAccountActivitySimulation;
    @BindView(R.id.img_zhanghu_logo)
    ImageView mImgZhanghuLogo;
    @BindView(R.id.img_mima_logo)
    ImageView mImgMimaLogo;
    @BindView(R.id.btn_login_activity_simulation)
    Button mBtnLoginActivitySimulation;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_simulation;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySimulation;
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

    @OnClick({R.id.img_return_activity_simulation, R.id.img_refresh_activity_simulation, R.id.btn_login_activity_simulation,R.id.rl_account_activity_simulation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_simulation:
                finish();
                break;
            case R.id.img_refresh_activity_simulation:
                break;
            case R.id.btn_login_activity_simulation:
                startActivity(new Intent(this,AccountActivity.class));
                break;
            case R.id.rl_account_activity_simulation:
                startActivity(new Intent(this,SelectAccountActivity.class));
                break;
        }
    }
}
