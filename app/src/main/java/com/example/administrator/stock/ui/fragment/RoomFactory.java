package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.room.DelicacyFragment;
import com.example.administrator.stock.ui.fragment.room.DiagnoseFragment;
import com.example.administrator.stock.ui.fragment.room.LiveFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class RoomFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new LiveFragment();
                    break;
                case 1:
                    baseFragment = new DelicacyFragment();
                    break;
                case 2:
                    baseFragment = new DiagnoseFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
