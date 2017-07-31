package com.example.administrator.stock.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.fragment.StrategyFactory;

/**
 * Created by Administrator on 2017/7/29.
 */

public class StrategyFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public StrategyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment baseFragment = StrategyFactory.createFragment(position);
        return baseFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
