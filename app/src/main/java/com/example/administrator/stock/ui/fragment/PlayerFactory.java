package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.player.HistoryFragment;
import com.example.administrator.stock.ui.fragment.player.HoldFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PlayerFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new HoldFragment();
                    break;
                case 1:
                    baseFragment = new HistoryFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
