package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class NewActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_new)
    LinearLayout mLlStatusActivityNew;
    @BindView(R.id.img_return_activity_new)
    ImageView mImgReturnActivityNew;
    @BindView(R.id.tv_collect_activity_new)
    TextView mTvCollectActivityNew;
    @BindView(R.id.rv_activity_new)
    RecyclerView mRvActivityNew;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityNew.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityNew.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityNew;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_new, R.id.tv_collect_activity_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_new:
                finish();
                break;
            case R.id.tv_collect_activity_new:
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(NewActivity.this).inflate(R.layout.item_rv_new, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewActivity.this,NewDetailsActivity.class));
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
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_new);


            }
        }
    }
}
