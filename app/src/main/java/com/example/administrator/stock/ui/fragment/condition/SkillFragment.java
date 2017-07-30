package com.example.administrator.stock.ui.fragment.condition;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/30.
 */

public class SkillFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_skill)
    RecyclerView mRvFragmentSkill;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_skill;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentSkill.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentSkill.setAdapter(new MyAdapter());

    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_skill, parent, false);
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
            private RelativeLayout mLayout;


            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_skill);


            }
        }
    }

}
