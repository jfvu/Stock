package com.example.administrator.stock.ui.fragment.stock;

import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.fragment.expert.CollectFragment;
import com.example.administrator.stock.ui.fragment.expert.ConcernFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class ExpertFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new ConcernFragment();
                    break;
                case 1:
                    baseFragment = new CollectFragment();
                    break;


                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
