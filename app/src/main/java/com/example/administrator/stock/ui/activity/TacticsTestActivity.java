package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.TacticsTestFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class TacticsTestActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_tacticstest)
    LinearLayout mLlStatusActivityTacticstest;
    @BindView(R.id.img_return_activity_ticticstest)
    ImageView mImgReturnActivityTicticstest;
    @BindView(R.id.tv_save_activity_tacticstest)
    TextView mTvSaveActivityTacticstest;
    @BindView(R.id.tl_activity_tacticstest)
    TabLayout mTlActivityTacticstest;
    @BindView(R.id.vp_activity_tacticstest)
    ViewPager mVpActivityTacticstest;
    private TacticsTestFragmentAdapter mTacticsTestFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTacticsTestFragmentAdapter = new TacticsTestFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityTacticstest.setAdapter(mTacticsTestFragmentAdapter);
        mTlActivityTacticstest.setupWithViewPager(mVpActivityTacticstest);

        mTlActivityTacticstest.getTabAt(0).setText("测试报告");
        mTlActivityTacticstest.getTabAt(1).setText("交易持仓");
        mTlActivityTacticstest.getTabAt(2).setText("规则统计");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityTacticstest.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityTacticstest.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityTacticstest));
        mTlActivityTacticstest.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityTacticstest));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tactics_test;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityTacticstest;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_ticticstest, R.id.tv_save_activity_tacticstest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_ticticstest:
                finish();
                break;
            case R.id.tv_save_activity_tacticstest:
                finish();
                break;
        }
    }

}
