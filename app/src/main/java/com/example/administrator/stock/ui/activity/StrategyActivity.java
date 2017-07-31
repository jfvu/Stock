package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.StrategyFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class StrategyActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_strategy)
    LinearLayout mLlStatusActivityStrategy;
    @BindView(R.id.img_return_activity_strategy)
    ImageView mImgReturnActivityStrategy;
    @BindView(R.id.tv_checkin_activity_strategy)
    TextView mTvCheckinActivityStrategy;
    @BindView(R.id.tl_activity_strategy)
    TabLayout mTlActivityStrategy;
    @BindView(R.id.vp_activity_strategy)
    ViewPager mVpActivityStrategy;
    private StrategyFragmentAdapter mStrategyFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mStrategyFragmentAdapter = new StrategyFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityStrategy.setAdapter(mStrategyFragmentAdapter);
        mTlActivityStrategy.setupWithViewPager(mVpActivityStrategy);

        mTlActivityStrategy.getTabAt(0).setText("总收益");
        mTlActivityStrategy.getTabAt(1).setText("年收益");
        mTlActivityStrategy.getTabAt(2).setText("90天收益");
        mTlActivityStrategy.getTabAt(3).setText("30天收益");
        mTlActivityStrategy.getTabAt(4).setText("当日收益");
        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityStrategy.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityStrategy.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityStrategy));
        mTlActivityStrategy.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityStrategy));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_strategy;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityStrategy;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_strategy, R.id.tv_checkin_activity_strategy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_strategy:
                finish();
                break;
            case R.id.tv_checkin_activity_strategy:
                break;
        }
    }
}
