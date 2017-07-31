package com.example.administrator.stock.ui.fragment.stock;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.ConditionFragmentAdapter;
import com.example.administrator.stock.adapter.EquationFragmentAdapter;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/30.
 */

public class EquationFragment extends BaseFragment {
    @BindView(R.id.tl_fragment_equation)
    TabLayout mTlFragmentEquation;
    @BindView(R.id.vp_fragment_equation)
    ViewPager mVpFragmentEquation;
    Unbinder unbinder;
    private EquationFragmentAdapter mEquationFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_equation;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mEquationFragmentAdapter = new EquationFragmentAdapter(getActivity().getSupportFragmentManager(),getActivity());
        mVpFragmentEquation.setAdapter(mEquationFragmentAdapter);
        mTlFragmentEquation.setupWithViewPager(mVpFragmentEquation);

        mTlFragmentEquation.getTabAt(0).setText("构件公式");
        mTlFragmentEquation.getTabAt(1).setText("组合公式");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlFragmentEquation.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpFragmentEquation.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlFragmentEquation));
        mTlFragmentEquation.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragmentEquation));

    }


}
