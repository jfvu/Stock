package com.example.administrator.stock.ui.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.StockFragmentAdapter;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class StockFragment extends BaseFragment {
    @BindView(R.id.tl_title_fragment_stock)
    TabLayout mTlTitleFragmentStock;
    @BindView(R.id.rl_title_fragment_stock)
    RelativeLayout mRlTitleFragmentStock;
    @BindView(R.id.vp_fragment_stock)
    ViewPager mVpFragmentStock;
    Unbinder unbinder;
    private StockFragmentAdapter mMainFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stock;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mMainFragmentAdapter = new StockFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity());
        mVpFragmentStock.setAdapter(mMainFragmentAdapter);
        mTlTitleFragmentStock.setupWithViewPager(mVpFragmentStock);

        mTlTitleFragmentStock.getTabAt(0).setCustomView(tab_icon("条件选股"));
        mTlTitleFragmentStock.getTabAt(1).setCustomView(tab_icon("智能盯盘"));
        mTlTitleFragmentStock.getTabAt(2).setCustomView(tab_icon("公式选股"));
        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlTitleFragmentStock.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpFragmentStock.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlTitleFragmentStock));
        mTlTitleFragmentStock.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragmentStock));

    }
    private View tab_icon(String name){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tablayout_stock,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(name);
        AutoUtils.autoSize(view);
        return view;
    }
}
