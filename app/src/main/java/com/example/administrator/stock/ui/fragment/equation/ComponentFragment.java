package com.example.administrator.stock.ui.fragment.equation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jiaofeng on 2017/7/30.
 */

public class ComponentFragment extends BaseFragment {
    @BindView(R.id.tv_edit_fragment_component)
    TextView mTvEditFragmentComponent;
    @BindView(R.id.btn_equation_fragment_component)
    Button mBtnEquationFragmentComponent;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_component;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_edit_fragment_component, R.id.btn_equation_fragment_component})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_edit_fragment_component:
                break;
            case R.id.btn_equation_fragment_component:
                break;
        }
    }
}
