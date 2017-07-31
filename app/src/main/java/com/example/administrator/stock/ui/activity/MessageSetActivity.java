package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.zcw.togglebutton.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageSetActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_messageset)
    LinearLayout mLlStatusActivityMessageset;
    @BindView(R.id.img_return_activity_messageset)
    ImageView mImgReturnActivityMessageset;
    @BindView(R.id.tb_1_activity_messageset)
    ToggleButton mTb1ActivityMessageset;
    @BindView(R.id.tb_2_activity_messageset)
    ToggleButton mTb2ActivityMessageset;
    @BindView(R.id.tb_3_activity_messageset)
    ToggleButton mTb3ActivityMessageset;
    @BindView(R.id.tb_4_activity_messageset)
    ToggleButton mTb4ActivityMessageset;
    @BindView(R.id.tb_5_activity_messageset)
    ToggleButton mTb5ActivityMessageset;
    @BindView(R.id.tb_6_activity_messageset)
    ToggleButton mTb6ActivityMessageset;
    @BindView(R.id.rl_choosevoice_activity_messageset)
    RelativeLayout mRlChoosevoiceActivityMessageset;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_set;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMessageset;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_messageset, R.id.rl_choosevoice_activity_messageset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_messageset:
                finish();
                break;
            case R.id.rl_choosevoice_activity_messageset:
                break;
        }
    }
}
