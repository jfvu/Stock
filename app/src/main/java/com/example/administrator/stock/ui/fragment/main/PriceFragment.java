package com.example.administrator.stock.ui.fragment.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.PriceFragmentAdapter;
import com.example.administrator.stock.ui.activity.SeachActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PriceFragment extends BaseFragment {
    @BindView(R.id.img_seach_fragemnt_price)
    ImageView mImgSeachFragemntPrice;
    @BindView(R.id.img_refresh_fragemnt_price)
    ImageView mImgRefreshFragemntPrice;
    @BindView(R.id.tl_fragment_price)
    TabLayout mTlFragmentPrice;
    @BindView(R.id.vp_fragment_price)
    ViewPager mVpFragmentPrice;
    Unbinder unbinder;
    private PriceFragmentAdapter mPriceFragmentAdapter;
    private Intent mIntent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_price;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPriceFragmentAdapter = new PriceFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity());
        mVpFragmentPrice.setAdapter(mPriceFragmentAdapter);
        mTlFragmentPrice.setupWithViewPager(mVpFragmentPrice);

        mTlFragmentPrice.getTabAt(0).setText("自选");
        mTlFragmentPrice.getTabAt(1).setText("沪深");
        mTlFragmentPrice.getTabAt(2).setText("板块");

        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlFragmentPrice.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpFragmentPrice.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlFragmentPrice));
        mTlFragmentPrice.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragmentPrice));
        mVpFragmentPrice.setCurrentItem(1);
    }


    @OnClick({R.id.img_seach_fragemnt_price, R.id.img_refresh_fragemnt_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_seach_fragemnt_price:
                mIntent = new Intent(getActivity(), SeachActivity.class);
                startActivity(mIntent);
                break;
            case R.id.img_refresh_fragemnt_price:
                break;
        }
    }
}
