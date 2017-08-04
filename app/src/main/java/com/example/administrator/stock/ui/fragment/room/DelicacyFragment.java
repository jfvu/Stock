package com.example.administrator.stock.ui.fragment.room;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/4.
 */

public class DelicacyFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_delicacy)
    RecyclerView mRvFragmentDelicacy;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_delicacy;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentDelicacy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentDelicacy.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_delicacy, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {




        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {



            public ViewHolder(View itemView) {
                super(itemView);



            }
        }
    }
}
