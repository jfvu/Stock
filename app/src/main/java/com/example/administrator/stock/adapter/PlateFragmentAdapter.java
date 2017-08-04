package com.example.administrator.stock.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.fragment.PlateFactory;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PlateFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public PlateFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment baseFragment = PlateFactory.createFragment(position);
        return baseFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
