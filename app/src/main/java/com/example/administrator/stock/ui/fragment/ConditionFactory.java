package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.condition.BasicFragment;
import com.example.administrator.stock.ui.fragment.condition.FeatureFragment;
import com.example.administrator.stock.ui.fragment.condition.KLineFragment;
import com.example.administrator.stock.ui.fragment.condition.RelationFragment;
import com.example.administrator.stock.ui.fragment.condition.SkillFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class ConditionFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new SkillFragment();
                    break;
                case 1:
                    baseFragment = new RelationFragment();
                    break;
                case 2:
                    baseFragment = new KLineFragment();
                    break;
                case 3:
                    baseFragment = new FeatureFragment();
                    break;
                case 4:
                    baseFragment = new BasicFragment();
                    break;

                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
