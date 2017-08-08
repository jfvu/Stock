package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.OperateFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class OperateActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_operate)
    LinearLayout mLlStatusActivityOperate;
    @BindView(R.id.rl_return_activity_operate)
    RelativeLayout mRlReturnActivityOperate;
    @BindView(R.id.rl_refresh_activity_operate)
    RelativeLayout mRlRefreshActivityOperate;
    @BindView(R.id.tl_activity_operater)
    TabLayout mTlActivityOperater;
    @BindView(R.id.vp_activity_operate)
    ViewPager mVpActivityOperate;
    private Intent mIntent;
    private OperateFragmentAdapter mOperateFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mIntent = getIntent();
        int i = mIntent.getIntExtra("OperateActivity",0);
        mOperateFragmentAdapter = new OperateFragmentAdapter(getSupportFragmentManager(), getApplication());
        mVpActivityOperate.setAdapter(mOperateFragmentAdapter);
        mTlActivityOperater.setupWithViewPager(mVpActivityOperate);

        mTlActivityOperater.getTabAt(0).setText("买入");
        mTlActivityOperater.getTabAt(1).setText("卖出");
        mTlActivityOperater.getTabAt(2).setText("撤单");
        mTlActivityOperater.getTabAt(3).setText("持仓");
        mTlActivityOperater.getTabAt(4).setText("查询");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityOperater.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityOperate.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityOperater));
        mTlActivityOperater.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityOperate));
        mVpActivityOperate.setCurrentItem(i);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_operate;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityOperate;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.rl_return_activity_operate, R.id.rl_refresh_activity_operate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_operate:
                finish();
                break;
            case R.id.rl_refresh_activity_operate:
                break;
        }
    }
}
