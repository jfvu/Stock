package com.example.administrator.stock.ui.fragment.room;

import android.content.Intent;
import android.widget.Button;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.ChatActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/4.
 */

public class LiveFragment extends BaseFragment {
    @BindView(R.id.btn_join)
    Button mBtnJoin;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_room;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @OnClick(R.id.btn_join)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(),ChatActivity.class));
    }
}
