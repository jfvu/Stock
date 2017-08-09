package com.example.administrator.stock.ui.fragment.operater;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.DealActivity;
import com.example.administrator.stock.ui.activity.EntrustActivity;
import com.example.administrator.stock.ui.activity.HistoryDealActivity;
import com.example.administrator.stock.ui.activity.HistoryEntrustActivity;
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
    private Intent mIntent;

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
                mIntent = new Intent(getActivity(), EntrustActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_deal:
                mIntent = new Intent(getActivity(), DealActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_historyentrust:
                mIntent = new Intent(getActivity(), HistoryEntrustActivity.class);
                startActivity(mIntent);
                break;
            case R.id.ll_historydeal:
                mIntent = new Intent(getActivity(), HistoryDealActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
