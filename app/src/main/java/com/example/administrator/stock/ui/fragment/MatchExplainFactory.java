package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.matchexplain.ExplainFragment;
import com.example.administrator.stock.ui.fragment.matchexplain.RuleFragment;
import com.example.administrator.stock.ui.fragment.matchexplain.SetFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class MatchExplainFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new ExplainFragment();
                    break;
                case 1:
                    baseFragment = new SetFragment();
                    break;
                case 2:
                    baseFragment = new RuleFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
