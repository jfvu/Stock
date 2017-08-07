package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.RoomFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class RoomActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_room)
    LinearLayout mLlStatusActivityRoom;
    @BindView(R.id.img_return_activity_room)
    RelativeLayout mImgReturnActivityRoom;
    @BindView(R.id.img_seach_activity_room)
    ImageView mImgSeachActivityRoom;
    @BindView(R.id.btn_attention)
    Button mBtnAttention;
    @BindView(R.id.btn_collect)
    Button mBtnCollect;
    @BindView(R.id.tl_activity_room)
    TabLayout mTlActivityRoom;
    @BindView(R.id.vp_activity_room)
    ViewPager mVpActivityRoom;
    private RoomFragmentAdapter mRoomFragmentAdapter;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRoomFragmentAdapter = new RoomFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityRoom.setAdapter(mRoomFragmentAdapter);
        mTlActivityRoom.setupWithViewPager(mVpActivityRoom);

        mTlActivityRoom.getTabAt(0).setText("直播");
        mTlActivityRoom.getTabAt(1).setText("精品内参");
        mTlActivityRoom.getTabAt(2).setText("诊股");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityRoom.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityRoom.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityRoom));
        mTlActivityRoom.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityRoom));
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


    @OnClick({R.id.img_return_activity_room, R.id.img_seach_activity_room, R.id.btn_attention, R.id.btn_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_room:
                finish();
                break;
            case R.id.img_seach_activity_room:
                startActivity(new Intent(this, SeachActivity.class));
                break;
            case R.id.btn_attention:
                break;
            case R.id.btn_collect:
                break;
            /*case R.id.btn_join:
                startActivity(new Intent(this,ChatActivity.class));
                break;*/
        }
    }

}
