package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.supermarket.AiFragment;
import com.example.administrator.stock.ui.fragment.supermarket.BuildFragment;
import com.example.administrator.stock.ui.fragment.supermarket.DeputyFragment;
import com.example.administrator.stock.ui.fragment.supermarket.GroupFragment;
import com.example.administrator.stock.ui.fragment.supermarket.MapFragment;
import com.example.administrator.stock.ui.fragment.supermarket.TimeFragment;
import com.example.administrator.stock.ui.fragment.supermarket.WarnFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class SupermarketFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new MapFragment();
                    break;
                case 1:
                    baseFragment = new DeputyFragment();
                    break;
                case 2:
                    baseFragment = new TimeFragment();
                    break;
                case 3:
                    baseFragment = new WarnFragment();
                    break;
                case 4:
                    baseFragment = new BuildFragment();
                    break;
                case 5:
                    baseFragment = new GroupFragment();
                    break;
                case 6:
                    baseFragment = new AiFragment();
                    break;

                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
