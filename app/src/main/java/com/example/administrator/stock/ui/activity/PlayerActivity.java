package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.PlayerFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class PlayerActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_player)
    LinearLayout mLlStatusActivityPlayer;
    @BindView(R.id.img_return_activity_player)
    ImageView mImgReturnActivityPlayer;
    @BindView(R.id.tl_activity_player)
    TabLayout mTlActivityPlayer;
    @BindView(R.id.vp_activity_player)
    ViewPager mVpActivityPlayer;
    @BindView(R.id.btn_collect)
    Button mBtnCollect;
    private PlayerFragmentAdapter mPlayerFragmentAdapter;
    private boolean flag = false;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPlayerFragmentAdapter = new PlayerFragmentAdapter(getSupportFragmentManager(), getApplication());
        mVpActivityPlayer.setAdapter(mPlayerFragmentAdapter);
        mTlActivityPlayer.setupWithViewPager(mVpActivityPlayer);

        mTlActivityPlayer.getTabAt(0).setText("持仓");
        mTlActivityPlayer.getTabAt(1).setText("历史");


        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityPlayer.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityPlayer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityPlayer));
        mTlActivityPlayer.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityPlayer));
        if (!flag){
            mBtnCollect.setText("收藏");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_player;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityPlayer;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_player,R.id.btn_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_player:
                finish();
                break;
            case R.id.btn_collect:
                if (flag){
                    flag = false;
                    mBtnCollect.setText("收藏");
                }else {
                    flag = true;
                    mBtnCollect.setText("已收藏");
                }
                break;


        }

    }


}
