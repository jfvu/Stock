package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPassWordActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_forgetpassword)
    LinearLayout mLlStatusActivityForgetpassword;
    @BindView(R.id.img_return_activity_forgetpassword)
    RelativeLayout mImgReturnActivityForgetpassword;
    @BindView(R.id.btn_getcode_activity_forgetpassword)
    Button mBtnGetcodeActivityForgetpassword;
    @BindView(R.id.btn_finish_activity_forgetpassword)
    Button mBtnFinishActivityForgetpassword;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_pass_word;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityForgetpassword;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_forgetpassword, R.id.btn_getcode_activity_forgetpassword, R.id.btn_finish_activity_forgetpassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_forgetpassword:
                finish();
                break;
            case R.id.btn_getcode_activity_forgetpassword:
                break;
            case R.id.btn_finish_activity_forgetpassword:
                finish();
                break;
        }
    }
}
