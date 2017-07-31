package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.SupermarketFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SupermarketActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_supermarket)
    LinearLayout mLlStatusActivitySupermarket;
    @BindView(R.id.img_return_activity_supermarket)
    ImageView mImgReturnActivitySupermarket;
    @BindView(R.id.tv_ranking_activity_supermarket)
    TextView mTvRankingActivitySupermarket;
    @BindView(R.id.tl_activity_supermarket)
    TabLayout mTlActivitySupermarket;
    @BindView(R.id.vp_activity_supermarket)
    ViewPager mVpActivitySupermarket;
    private SupermarketFragmentAdapter mSupermarketFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mSupermarketFragmentAdapter = new SupermarketFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivitySupermarket.setAdapter(mSupermarketFragmentAdapter);
        mTlActivitySupermarket.setupWithViewPager(mVpActivitySupermarket);

        mTlActivitySupermarket.getTabAt(0).setText("主图公式");
        mTlActivitySupermarket.getTabAt(1).setText("副图公式");
        mTlActivitySupermarket.getTabAt(2).setText("分时公式");
        mTlActivitySupermarket.getTabAt(3).setText("预警公式");
        mTlActivitySupermarket.getTabAt(4).setText("构建公式");
        mTlActivitySupermarket.getTabAt(5).setText("组合公式");
        mTlActivitySupermarket.getTabAt(6).setText("ai策略");
        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivitySupermarket.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivitySupermarket.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivitySupermarket));
        mTlActivitySupermarket.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivitySupermarket));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_supermarket;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySupermarket;
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

    @OnClick({R.id.img_return_activity_supermarket, R.id.tv_ranking_activity_supermarket})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_supermarket:
                finish();
                break;
            case R.id.tv_ranking_activity_supermarket:
                break;
        }
    }
}
