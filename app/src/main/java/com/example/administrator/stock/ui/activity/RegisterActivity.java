package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_register)
    LinearLayout mLlStatusActivityRegister;
    @BindView(R.id.img_return_activity_register)
    ImageView mImgReturnActivityRegister;
    @BindView(R.id.btn_getcode_activity_register)
    Button mBtnGetcodeActivityRegister;
    @BindView(R.id.btn_sure_activity_register)
    Button mBtnSureActivityRegister;
    @BindView(R.id.tv_return_activity_register)
    TextView mTvReturnActivityRegister;
    @BindView(R.id.tv_declaration_activity_register)
    TextView mTvDeclarationActivityRegister;
    private Intent mIntent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityRegister;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_register, R.id.btn_getcode_activity_register,R.id.tv_declaration_activity_register, R.id.btn_sure_activity_register, R.id.tv_return_activity_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_register:
                finish();
                break;
            case R.id.btn_getcode_activity_register:
                break;
            case R.id.btn_sure_activity_register:
                finish();
                break;
            case R.id.tv_return_activity_register:
                finish();
                break;
            case R.id.tv_declaration_activity_register:
                mIntent = new Intent(this,DeclarationActivity.class);
                startActivity(mIntent);
                break;
        }
    }

}
