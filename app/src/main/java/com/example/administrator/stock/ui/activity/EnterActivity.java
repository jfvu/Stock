package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class EnterActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_enter)
    LinearLayout mLlStatusActivityEnter;
    @BindView(R.id.img_return_activity_enter)
    ImageView mImgReturnActivityEnter;
    @BindView(R.id.tv_finish)
    TextView mTvFinish;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_enter;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityEnter;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_enter, R.id.tv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_enter:
                finish();
                break;
            case R.id.tv_finish:
                finish();
                break;
        }
    }
}
