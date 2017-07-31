package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.formula.BuyFragment;
import com.example.administrator.stock.ui.fragment.formula.EditFragment;
import com.example.administrator.stock.ui.fragment.formula.RankingFragment;
import com.example.administrator.stock.ui.fragment.formula.ReleaseFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class FormulaFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new EditFragment();
                    break;
                case 1:
                    baseFragment = new RankingFragment();
                    break;
                case 2:
                    baseFragment = new BuyFragment();
                    break;
                case 3:
                    baseFragment = new ReleaseFragment();
                    break;


                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
