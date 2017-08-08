package com.example.administrator.stock.ui.fragment.operater;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/8.
 */

public class HoldFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_hold)
    RecyclerView mRvFragmentHold;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hold1;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentHold.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentHold.setAdapter(new MyAdapter());
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_back, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            /*holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPop();
                }
            });*/



        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private LinearLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_back);
            }
        }
    }
}
