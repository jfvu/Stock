package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.price.HuShenFragment;
import com.example.administrator.stock.ui.fragment.price.ModuleFragment;
import com.example.administrator.stock.ui.fragment.price.OptionalFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PriceFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new OptionalFragment();
                    break;
                case 1:
                    baseFragment = new HuShenFragment();
                    break;
                case 2:
                    baseFragment = new ModuleFragment();
                    break;

                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
