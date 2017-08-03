package com.example.administrator.stock.ui.fragment.main;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.PriceFragmentAdapter;
import com.example.administrator.stock.ui.activity.SeachActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.view.PricePop;

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
    private PricePop mPricePop;
    private WindowManager.LayoutParams lp;
    private Window window;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_price;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPriceFragmentAdapter = new PriceFragmentAdapter(getChildFragmentManager(),getActivity());
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
        mVpFragmentPrice.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    mImgRefreshFragemntPrice.setImageResource(R.drawable.all_add);
                }else {
                    mImgRefreshFragemntPrice.setImageResource(R.drawable.price_refresh);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @OnClick({R.id.img_seach_fragemnt_price, R.id.img_refresh_fragemnt_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_seach_fragemnt_price:
                mIntent = new Intent(getActivity(), SeachActivity.class);
                startActivity(mIntent);
                break;
            case R.id.img_refresh_fragemnt_price:
                if (mVpFragmentPrice.getCurrentItem() == 0){
                    openPop();
                }
                break;
        }
    }
    private void openPop(){
        mPricePop = new PricePop(getActivity(),onClickListener);
        window = getActivity().getWindow();
        lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
        mPricePop.setTouchable(true);
        mPricePop.setFocusable(true);
        mPricePop.setBackgroundDrawable(new BitmapDrawable());
        mPricePop.setOutsideTouchable(true);



        mPricePop.showAtLocation(getActivity().findViewById(R.id.rl_all_activity_main), Gravity.CENTER,0,0);
        mPricePop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {

                lp.alpha = 1f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);
            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_no_pop_match:
                    mPricePop.dismiss();
                case R.id.btn_yes_pop_match:
                    mPricePop.dismiss();
                    break;


            }
        }
    };

}
