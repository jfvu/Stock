package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.operater.BackFragment;
import com.example.administrator.stock.ui.fragment.operater.BuyFragment;
import com.example.administrator.stock.ui.fragment.operater.HoldFragment;
import com.example.administrator.stock.ui.fragment.operater.SeachFragment;
import com.example.administrator.stock.ui.fragment.operater.SellFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class OperateFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new BuyFragment();
                    break;
                case 1:
                    baseFragment = new SellFragment();
                    break;
                case 2:
                    baseFragment = new BackFragment();
                    break;
                case 3:
                    baseFragment = new HoldFragment();
                    break;
                case 4:
                    baseFragment = new SeachFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
