package com.example.administrator.stock.ui.fragment.formula;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.GroupActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/31.
 */

public class EditFragment extends BaseFragment {
    @BindView(R.id.rv_fragment_edit)
    RecyclerView mRvFragmentEdit;
    Unbinder unbinder;
    @BindView(R.id.ll_1_fragment_edit)
    LinearLayout mLl1FragmentEdit;
    @BindView(R.id.ll_2_fragment_edit)
    LinearLayout mLl2FragmentEdit;
    @BindView(R.id.ll_3_fragment_edit)
    LinearLayout mLl3FragmentEdit;
    @BindView(R.id.ll_4_fragment_edit)
    LinearLayout mLl4FragmentEdit;
    @BindView(R.id.ll_5_fragment_edit)
    LinearLayout mLl5FragmentEdit;
    @BindView(R.id.ll_6_fragment_edit)
    LinearLayout mLl6FragmentEdit;
    Unbinder unbinder1;
    private Intent mIntent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_edit;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvFragmentEdit.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFragmentEdit.setAdapter(new MyAdapter());
    }


    @OnClick({R.id.ll_1_fragment_edit, R.id.ll_2_fragment_edit, R.id.ll_3_fragment_edit, R.id.ll_4_fragment_edit, R.id.ll_5_fragment_edit, R.id.ll_6_fragment_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_1_fragment_edit:
                break;
            case R.id.ll_2_fragment_edit:
                break;
            case R.id.ll_3_fragment_edit:
                break;
            case R.id.ll_4_fragment_edit:
                break;
            case R.id.ll_5_fragment_edit:
                break;
            case R.id.ll_6_fragment_edit:
                mIntent = new Intent(getActivity(), GroupActivity.class);
                startActivity(mIntent);
                break;
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_edit, parent, false);
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
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_item_rv_edit);


            }
        }
    }
}
