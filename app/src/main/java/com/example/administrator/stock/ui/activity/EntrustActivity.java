package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class EntrustActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_entrust)
    LinearLayout mLlStatusActivityEntrust;
    @BindView(R.id.rl_return_activity_entrust)
    RelativeLayout mRlReturnActivityEntrust;
    @BindView(R.id.rv_activity_entrust)
    RecyclerView mRvActivityEntrust;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityEntrust.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityEntrust.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_entrust;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityEntrust;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick(R.id.rl_return_activity_entrust)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(EntrustActivity.this).inflate(R.layout.item_rv_entrust, parent, false);
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
