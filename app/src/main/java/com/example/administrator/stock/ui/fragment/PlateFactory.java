package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.plate.FallFragment;
import com.example.administrator.stock.ui.fragment.plate.NewFragment;
import com.example.administrator.stock.ui.fragment.plate.RiseFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PlateFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new RiseFragment();
                    break;
                case 1:
                    baseFragment = new FallFragment();
                    break;
                case 2:
                    baseFragment = new NewFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
