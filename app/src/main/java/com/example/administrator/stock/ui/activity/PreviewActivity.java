package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PreviewActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_preview)
    LinearLayout mLlStatusActivityPreview;
    @BindView(R.id.img_return_activity_preview)
    RelativeLayout mImgReturnActivityPreview;
    @BindView(R.id.tv_chang_activity_preview)
    TextView mTvChangActivityPreview;
    @BindView(R.id.btn_save_activity_preview)
    Button mBtnSaveActivityPreview;
    @BindView(R.id.btn_release_activity_preview)
    Button mBtnReleaseActivityPreview;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_preview;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityPreview;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_preview, R.id.tv_chang_activity_preview, R.id.btn_save_activity_preview, R.id.btn_release_activity_preview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_preview:
                finish();
                break;
            case R.id.tv_chang_activity_preview:
                break;
            case R.id.btn_save_activity_preview:
                finish();
                break;
            case R.id.btn_release_activity_preview:
                finish();
                break;
        }
    }
}
