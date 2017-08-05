package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.zcw.togglebutton.ToggleButton;

import butterknife.BindView;
import butterknife.OnClick;

public class TendencyActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_tendency)
    LinearLayout mLlStatusActivityTendency;
    @BindView(R.id.img_return_activity_tendency)
    ImageView mImgReturnActivityTendency;
    @BindView(R.id.tb_2_activity_messageset)
    ToggleButton mTb2ActivityMessageset;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tendency;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityTendency;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_tendency)
    public void onViewClicked() {
        finish();
    }
}
