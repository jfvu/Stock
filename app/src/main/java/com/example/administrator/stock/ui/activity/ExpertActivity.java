package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.ExpertFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class ExpertActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_expert)
    LinearLayout mLlStatusActivityExpert;
    @BindView(R.id.img_return_activity_expert)
    ImageView mImgReturnActivityExpert;
    @BindView(R.id.tl_activity_expert)
    TabLayout mTlActivityExpert;
    @BindView(R.id.vp_activity_expert)
    ViewPager mVpActivityExpert;
    private ExpertFragmentAdapter mExpertFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mExpertFragmentAdapter = new ExpertFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityExpert.setAdapter(mExpertFragmentAdapter);
        mTlActivityExpert.setupWithViewPager(mVpActivityExpert);

        mTlActivityExpert.getTabAt(0).setText("我的关注");
        mTlActivityExpert.getTabAt(1).setText("我的收藏");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityExpert.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityExpert.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityExpert));
        mTlActivityExpert.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityExpert));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expert;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityExpert;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick(R.id.img_return_activity_expert)
    public void onViewClicked() {
        finish();
    }
}
