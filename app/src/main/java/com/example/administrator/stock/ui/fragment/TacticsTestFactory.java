package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.tacticstest.DealFragment;
import com.example.administrator.stock.ui.fragment.tacticstest.ReportFragment;
import com.example.administrator.stock.ui.fragment.tacticstest.StatisticsFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class TacticsTestFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new ReportFragment();
                    break;
                case 1:
                    baseFragment = new DealFragment();
                    break;
                case 2:
                    baseFragment = new StatisticsFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
