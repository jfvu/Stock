package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.main.FormulaFragment;
import com.example.administrator.stock.ui.fragment.main.MainFragment;
import com.example.administrator.stock.ui.fragment.main.MessageFragment;
import com.example.administrator.stock.ui.fragment.main.PriceFragment;
import com.example.administrator.stock.ui.fragment.main.StockFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class FragmentFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new MainFragment();
                    break;
                case 1:
                    baseFragment = new PriceFragment();
                    break;
                case 2:
                    baseFragment = new MessageFragment();
                    break;
                case 3:
                    baseFragment = new StockFragment();
                    break;
                case 4:
                    baseFragment = new FormulaFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
