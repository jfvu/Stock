package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.zcw.togglebutton.ToggleButton;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowSetActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_showset)
    LinearLayout mLlStatusActivityShowset;
    @BindView(R.id.img_return_activity_showset)
    RelativeLayout mImgReturnActivityShowset;
    @BindView(R.id.tb_1_activity_showset)
    ToggleButton mTb1ActivityShowset;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_set;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityShowset;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_showset)
    public void onViewClicked() {
        finish();
    }
}
