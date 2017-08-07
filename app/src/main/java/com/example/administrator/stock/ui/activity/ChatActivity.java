package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_chat)
    LinearLayout mLlStatusActivityChat;
    @BindView(R.id.img_return_activity_chat)
    RelativeLayout mImgReturnActivityChat;
    @BindView(R.id.tv_just)
    TextView mTvJust;
    @BindView(R.id.img_face)
    ImageView mImgFace;
    @BindView(R.id.img_picture)
    ImageView mImgPicture;
    @BindView(R.id.img_send)
    ImageView mImgSend;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityChat;
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

    @OnClick({R.id.img_return_activity_chat, R.id.tv_just, R.id.img_face, R.id.img_picture, R.id.img_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_chat:
                finish();
                break;
            case R.id.tv_just:
                break;
            case R.id.img_face:
                break;
            case R.id.img_picture:
                break;
            case R.id.img_send:
                break;
        }
    }
}
