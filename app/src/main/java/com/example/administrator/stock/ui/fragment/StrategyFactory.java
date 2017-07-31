package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.strategy.AllFragment;
import com.example.administrator.stock.ui.fragment.strategy.DayFragment;
import com.example.administrator.stock.ui.fragment.strategy.NinetyFragment;
import com.example.administrator.stock.ui.fragment.strategy.ThirtyFragment;
import com.example.administrator.stock.ui.fragment.strategy.YearFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class StrategyFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new AllFragment();
                    break;
                case 1:
                    baseFragment = new YearFragment();
                    break;
                case 2:
                    baseFragment = new NinetyFragment();
                    break;
                case 3:
                    baseFragment = new ThirtyFragment();
                    break;
                case 4:
                    baseFragment = new DayFragment();
                    break;

                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
