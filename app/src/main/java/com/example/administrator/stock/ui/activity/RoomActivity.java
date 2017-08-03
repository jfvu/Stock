package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class RoomActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_room)
    LinearLayout mLlStatusActivityRoom;
    @BindView(R.id.img_return_activity_room)
    ImageView mImgReturnActivityRoom;
    @BindView(R.id.img_seach_activity_room)
    ImageView mImgSeachActivityRoom;
    @BindView(R.id.btn_attention)
    Button mBtnAttention;
    @BindView(R.id.btn_collect)
    Button mBtnCollect;
    @BindView(R.id.rb_live)
    RadioButton mRbLive;
    @BindView(R.id.rb_delicacy)
    RadioButton mRbDelicacy;
    @BindView(R.id.rb_diagnose)
    RadioButton mRbDiagnose;
    @BindView(R.id.btn_join)
    Button mBtnJoin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRbLive.setChecked(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityRoom;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_room, R.id.img_seach_activity_room, R.id.btn_attention, R.id.btn_collect, R.id.btn_join})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_room:
                finish();
                break;
            case R.id.img_seach_activity_room:
                startActivity(new Intent(this,SeachActivity.class));
                break;
            case R.id.btn_attention:
                break;
            case R.id.btn_collect:
                break;
            case R.id.btn_join:
                startActivity(new Intent(this,ChatActivity.class));
                break;
        }
    }
}
