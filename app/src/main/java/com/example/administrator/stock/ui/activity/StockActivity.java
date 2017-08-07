package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StockActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_stock)
    LinearLayout mLlStatusActivityStock;
    @BindView(R.id.img_return_activity_stock)
    RelativeLayout mImgReturnActivityStock;
    @BindView(R.id.img_refresh_activity_stock)
    ImageView mImgRefreshActivityStock;
    @BindView(R.id.img_1)
    ImageView mImg1;
    @BindView(R.id.img_2)
    ImageView mImg2;
    @BindView(R.id.img_3)
    ImageView mImg3;
    @BindView(R.id.img_4)
    ImageView mImg4;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stock;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityStock;
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

    @OnClick({R.id.img_return_activity_stock, R.id.img_refresh_activity_stock, R.id.img_1, R.id.img_2, R.id.img_3, R.id.img_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_stock:
                finish();
                break;
            case R.id.img_refresh_activity_stock:
                break;
            case R.id.img_1:
                break;
            case R.id.img_2:
                break;
            case R.id.img_3:
                mIntent = new Intent(this,WarnActivity.class);
                startActivity(mIntent);
                break;
            case R.id.img_4:
                mIntent = new Intent(this,DiagnoseActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
