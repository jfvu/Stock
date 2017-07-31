package com.example.administrator.stock.ui.fragment.stock;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.ConditionFragmentAdapter;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/30.
 */

public class ConditionFragment extends BaseFragment {
    @BindView(R.id.tl_fragment_condition)
    TabLayout mTlFragmentCondition;
    @BindView(R.id.vp_fragment_condition)
    ViewPager mVpFragmentCondition;
    Unbinder unbinder;
    private ConditionFragmentAdapter mConditionFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_condition;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mConditionFragmentAdapter = new ConditionFragmentAdapter(getChildFragmentManager(),getActivity());
        mVpFragmentCondition.setAdapter(mConditionFragmentAdapter);
        mTlFragmentCondition.setupWithViewPager(mVpFragmentCondition);

        mTlFragmentCondition.getTabAt(0).setText("技术指标");
        mTlFragmentCondition.getTabAt(1).setText("量价关系");
        mTlFragmentCondition.getTabAt(2).setText("K线形态");
        mTlFragmentCondition.getTabAt(3).setText("特色");
        mTlFragmentCondition.getTabAt(4).setText("基本面");
        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlFragmentCondition.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpFragmentCondition.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlFragmentCondition));
        mTlFragmentCondition.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragmentCondition));
    }


}
