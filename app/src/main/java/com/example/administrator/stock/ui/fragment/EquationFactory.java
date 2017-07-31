package com.example.administrator.stock.ui.fragment;

import com.example.administrator.stock.ui.fragment.equation.ComponentFragment;
import com.example.administrator.stock.ui.fragment.equation.GroupFragment;
import com.example.administrator.stock.ui.fragment.stock.AiFragment;
import com.example.administrator.stock.ui.fragment.stock.ConditionFragment;
import com.example.administrator.stock.ui.fragment.stock.EquationFragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/29.
 */

public class EquationFactory {
    public static HashMap<Integer,BaseFragment> fragmentHashMap = new HashMap<>();
    public static BaseFragment createFragment(int pos){
        BaseFragment baseFragment = fragmentHashMap.get(pos);
        if (baseFragment == null){
            switch (pos){
                case 0:
                    baseFragment = new ComponentFragment();
                    break;
                case 1:
                    baseFragment = new GroupFragment();
                    break;


                default:
                    break;
            }
            fragmentHashMap.put(pos,baseFragment);
        }
        return baseFragment;
    }
}
