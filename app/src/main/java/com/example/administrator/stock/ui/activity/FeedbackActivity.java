package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FeedbackActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_feedback)
    LinearLayout mLlStatusActivityFeedback;
    @BindView(R.id.img_return_activity_feedback)
    ImageView mImgReturnActivityFeedback;
    @BindView(R.id.btn_submit_activity_feedback)
    Button mBtnSubmitActivityFeedback;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityFeedback;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_feedback, R.id.btn_submit_activity_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_feedback:
                finish();
                break;
            case R.id.btn_submit_activity_feedback:
                finish();
                break;
        }
    }
}
