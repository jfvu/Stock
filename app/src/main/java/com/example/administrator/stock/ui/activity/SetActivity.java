package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SetActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_set)
    LinearLayout mLlStatusActivitySet;
    @BindView(R.id.img_return_activity_set)
    ImageView mImgReturnActivitySet;
    @BindView(R.id.rl_phone_activity_set)
    RelativeLayout mRlPhoneActivitySet;
    @BindView(R.id.rl_font_activity_set)
    RelativeLayout mRlFontActivitySet;
    @BindView(R.id.rl_feedback_activity_set)
    RelativeLayout mRlFeedbackActivitySet;
    @BindView(R.id.rl_about_activity_set)
    RelativeLayout mRlAboutActivitySet;
    @BindView(R.id.rl_skin_activity_set)
    RelativeLayout mRlSkinActivitySet;
    @BindView(R.id.rl_cache_activity_set)
    RelativeLayout mRlCacheActivitySet;
    @BindView(R.id.rl_logout_activity_set)
    RelativeLayout mRlLogoutActivitySet;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySet;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_set, R.id.rl_phone_activity_set, R.id.rl_font_activity_set, R.id.rl_feedback_activity_set, R.id.rl_about_activity_set, R.id.rl_skin_activity_set, R.id.rl_cache_activity_set, R.id.rl_logout_activity_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_set:
                finish();
                break;
            case R.id.rl_phone_activity_set:
                break;
            case R.id.rl_font_activity_set:
                break;
            case R.id.rl_feedback_activity_set:
                mIntent = new Intent(this,FeedbackActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_about_activity_set:
                mIntent = new Intent(this,AboutActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_skin_activity_set:
                break;
            case R.id.rl_cache_activity_set:
                break;
            case R.id.rl_logout_activity_set:
                mIntent = new Intent(this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                finish();
                break;
        }
    }
}
