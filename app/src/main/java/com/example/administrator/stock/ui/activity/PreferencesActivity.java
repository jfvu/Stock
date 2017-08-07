package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PreferencesActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_preferences)
    LinearLayout mLlStatusActivityPreferences;
    @BindView(R.id.img_return_activity_preferences)
    RelativeLayout mImgReturnActivityPreferences;
    @BindView(R.id.btn_next_activity_preferences)
    Button mBtnNextActivityPreferences;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_preferences;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityPreferences;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_preferences, R.id.btn_next_activity_preferences})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_preferences:
                finish();
                break;
            case R.id.btn_next_activity_preferences:
                startActivity(new Intent(this,FunctionActivity.class));
                break;
        }
    }
}
