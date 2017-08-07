package com.example.administrator.stock.ui.fragment.player;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/5.
 */

public class HistoryFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_history)
    RecyclerView mRvFragmentHistory;
    @BindView(R.id.ll_comment)
    LinearLayout mLlComment;
    @BindView(R.id.ll_subscribe)
    LinearLayout mLlSubscribe;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentHistory.setAdapter(new MyAdapter());

    }


    @OnClick({R.id.ll_comment, R.id.ll_subscribe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_comment:
                break;
            case R.id.ll_subscribe:
                break;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_history, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private LinearLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_reply);
            }
        }
    }
}
