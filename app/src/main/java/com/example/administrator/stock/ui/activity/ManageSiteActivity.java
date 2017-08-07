package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ManageSiteActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_managesite)
    LinearLayout mLlStatusActivityManagesite;
    @BindView(R.id.img_return_activity_managesite)
    RelativeLayout mImgReturnActivityManagesite;
    @BindView(R.id.img_open_activity_managesite)
    ImageView mImgOpenActivityManagesite;
    @BindView(R.id.btn_change_activity_managesite)
    Button mBtnChangeActivityManagesite;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_manage_site;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityManagesite;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_managesite, R.id.img_open_activity_managesite, R.id.btn_change_activity_managesite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_managesite:
                finish();
                break;
            case R.id.img_open_activity_managesite:
                break;
            case R.id.btn_change_activity_managesite:
                finish();
                break;
        }
    }
}
