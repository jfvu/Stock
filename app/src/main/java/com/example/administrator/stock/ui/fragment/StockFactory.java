package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.stock.AiFragment;
import com.example.administrator.stock.ui.fragment.stock.ConditionFragment;
import com.example.administrator.stock.ui.fragment.stock.EquationFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class StockFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new ConditionFragment();
                    break;
                case 1:
                    baseFragment = new AiFragment();
                    break;
                case 2:
                    baseFragment = new EquationFragment();
                    break;

                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
