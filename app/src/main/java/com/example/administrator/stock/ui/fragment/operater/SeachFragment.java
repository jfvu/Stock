package com.example.administrator.stock.ui.fragment.operater;

import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/8.
 */

public class SeachFragment extends BaseFragment {
    @BindView(R.id.ll_entrust)
    LinearLayout mLlEntrust;
    @BindView(R.id.ll_deal)
    LinearLayout mLlDeal;
    @BindView(R.id.ll_historyentrust)
    LinearLayout mLlHistoryentrust;
    @BindView(R.id.ll_historydeal)
    LinearLayout mLlHistorydeal;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_seach;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.ll_entrust, R.id.ll_deal, R.id.ll_historyentrust, R.id.ll_historydeal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_entrust:
                break;
            case R.id.ll_deal:
                break;
            case R.id.ll_historyentrust:
                break;
            case R.id.ll_historydeal:
                break;
        }
    }
}
