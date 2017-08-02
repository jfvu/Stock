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

public class AccountActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_account)
    LinearLayout mLlStatusActivityAccount;
    @BindView(R.id.img_refresh_activity_account)
    ImageView mImgRefreshActivityAccount;
    @BindView(R.id.ll_buy_activity_accound)
    LinearLayout mLlBuyActivityAccound;
    @BindView(R.id.ll_sell_activity_accound)
    LinearLayout mLlSellActivityAccound;
    @BindView(R.id.ll_back_activity_accound)
    LinearLayout mLlBackActivityAccound;
    @BindView(R.id.ll_hold_activity_accound)
    LinearLayout mLlHoldActivityAccound;
    @BindView(R.id.ll_seach_activity_accound)
    LinearLayout mLlSeachActivityAccound;
    @BindView(R.id.ll_ai_activity_accound)
    LinearLayout mLlAiActivityAccound;
    @BindView(R.id.ll_match_activity_accound)
    LinearLayout mLlMatchActivityAccound;
    @BindView(R.id.btn_out_activity_accound)
    Button mBtnOutActivityAccound;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAccount;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_refresh_activity_account, R.id.ll_buy_activity_accound, R.id.ll_sell_activity_accound, R.id.ll_back_activity_accound, R.id.ll_hold_activity_accound, R.id.ll_seach_activity_accound, R.id.ll_ai_activity_accound, R.id.ll_match_activity_accound, R.id.btn_out_activity_accound})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_refresh_activity_account:
                break;
            case R.id.ll_buy_activity_accound:
                break;
            case R.id.ll_sell_activity_accound:
                break;
            case R.id.ll_back_activity_accound:
                break;
            case R.id.ll_hold_activity_accound:
                break;
            case R.id.ll_seach_activity_accound:
                break;
            case R.id.ll_ai_activity_accound:
                mIntent = new Intent(this,AiActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_match_activity_accound:
                mIntent = new Intent(this,MatchActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_out_activity_accound:
                finish();
                break;
        }
    }
}
