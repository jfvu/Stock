package com.example.administrator.stock.ui.fragment.plate;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.NewDetailsActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/4.
 */

public class NewFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_new)
    RecyclerView mRvFragmentNew;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_new;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentNew.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentNew.setAdapter(new MyAdapter());
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_fragment_new, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), NewDetailsActivity.class));
                }
            });


        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private LinearLayout mLayout;
            private LinearLayout mCollect,mShare;
            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_1);
                mCollect = (LinearLayout) itemView.findViewById(R.id.ll_collect);
                mShare = (LinearLayout) itemView.findViewById(R.id.ll_share);
            }
        }
    }
}
