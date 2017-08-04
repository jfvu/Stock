package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.PlateFragmentAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class PlateActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_plate)
    LinearLayout mLlStatusActivityPlate;
    @BindView(R.id.img_return_activity_plate)
    ImageView mImgReturnActivityPlate;
    @BindView(R.id.img_refresh_activity_plate)
    ImageView mImgRefreshActivityPlate;
    @BindView(R.id.ll_average)
    LinearLayout mLlAverage;
    @BindView(R.id.ll_power)
    LinearLayout mLlPower;
    @BindView(R.id.tl_activity_plate)
    TabLayout mTlActivityPlate;
    @BindView(R.id.vp_activity_plate)
    ViewPager mVpActivityPlate;
    private PlateFragmentAdapter mPlateFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPlateFragmentAdapter = new PlateFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityPlate.setAdapter(mPlateFragmentAdapter);
        mTlActivityPlate.setupWithViewPager(mVpActivityPlate);

        mTlActivityPlate.getTabAt(0).setText("涨幅榜");
        mTlActivityPlate.getTabAt(1).setText("跌幅榜");
        mTlActivityPlate.getTabAt(2).setText("新闻");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityPlate.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityPlate.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityPlate));
        mTlActivityPlate.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityPlate));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plate;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityPlate;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }

    @OnClick({R.id.img_return_activity_plate, R.id.img_refresh_activity_plate, R.id.ll_average, R.id.ll_power})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_plate:
                finish();
                break;
            case R.id.img_refresh_activity_plate:
                break;
            case R.id.ll_average:
                break;
            case R.id.ll_power:
                break;
        }
    }
}
