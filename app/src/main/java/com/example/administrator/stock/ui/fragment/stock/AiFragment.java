package com.example.administrator.stock.ui.fragment.stock;

import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zcw.togglebutton.ToggleButton;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/30.
 */

public class AiFragment extends BaseFragment {
    @BindView(R.id.rl_integrate_fragment_ai)
    RelativeLayout mRlIntegrateFragmentAi;
    @BindView(R.id.tb_warn_fragment_ai)
    ToggleButton mTbWarnFragmentAi;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ai;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }



    @OnClick(R.id.rl_integrate_fragment_ai)
    public void onViewClicked() {
    }
}
