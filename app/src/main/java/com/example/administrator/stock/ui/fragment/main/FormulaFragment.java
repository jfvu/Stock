package com.example.administrator.stock.ui.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.FormulaFragmentAdapter;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class FormulaFragment extends BaseFragment {
    @BindView(R.id.tv_creat_fragment_formula)
    TextView mTvCreatFragmentFormula;
    @BindView(R.id.tl_fragment_formula)
    TabLayout mTlFragmentFormula;
    @BindView(R.id.vp_fragment_formula)
    ViewPager mVpFragmentFormula;
    Unbinder unbinder;
    private FormulaFragmentAdapter mFormulaFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_formula;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mFormulaFragmentAdapter = new FormulaFragmentAdapter(getChildFragmentManager(),getActivity());
        mVpFragmentFormula.setAdapter(mFormulaFragmentAdapter);
        mTlFragmentFormula.setupWithViewPager(mVpFragmentFormula);

        mTlFragmentFormula.getTabAt(0).setText("自编辑");
        mTlFragmentFormula.getTabAt(1).setText("排行榜");
        mTlFragmentFormula.getTabAt(2).setText("购买的");
        mTlFragmentFormula.getTabAt(3).setText("发布的");

        /*LinearLayout linearLayout = (LinearLayout) mTlTitleFragmentStock.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));*/
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlFragmentFormula.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpFragmentFormula.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlFragmentFormula));
        mTlFragmentFormula.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpFragmentFormula));
    }


    @OnClick(R.id.tv_creat_fragment_formula)
    public void onViewClicked() {
    }
}
