package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.MatchExplainFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchExplainActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_matchexplain)
    LinearLayout mLlStatusActivityMatchexplain;
    @BindView(R.id.img_return_activity_matchexplain)
    ImageView mImgReturnActivityMatchexplain;
    @BindView(R.id.tl_activity_matchexplain)
    TabLayout mTlActivityMatchexplain;
    @BindView(R.id.vp_activity_matchexplain)
    ViewPager mVpActivityMatchexplain;
    @BindView(R.id.btn_apply_activity_matchexplain)
    Button mBtnApplyActivityMatchexplain;
    private MatchExplainFragmentAdapter mExplainFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mExplainFragmentAdapter = new MatchExplainFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityMatchexplain.setAdapter(mExplainFragmentAdapter);
        mTlActivityMatchexplain.setupWithViewPager(mVpActivityMatchexplain);

        mTlActivityMatchexplain.getTabAt(0).setText("比赛说明");
        mTlActivityMatchexplain.getTabAt(1).setText("奖项设置");
        mTlActivityMatchexplain.getTabAt(2).setText("交易规则");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityMatchexplain.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityMatchexplain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityMatchexplain));
        mTlActivityMatchexplain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityMatchexplain));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_explain;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMatchexplain;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_matchexplain, R.id.btn_apply_activity_matchexplain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_matchexplain:
                finish();
                break;
            case R.id.btn_apply_activity_matchexplain:
                finish();
                break;
        }
    }
}
