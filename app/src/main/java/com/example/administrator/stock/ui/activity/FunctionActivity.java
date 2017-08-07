package com.example.administrator.stock.ui.activity;

import android.content.Intent;
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

public class FunctionActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_function)
    LinearLayout mLlStatusActivityFunction;
    @BindView(R.id.img_return_activity_function)
    RelativeLayout mImgReturnActivityFunction;
    @BindView(R.id.rv_activity_function)
    RecyclerView mRvActivityFunction;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityFunction.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityFunction.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_function;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityFunction;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick(R.id.img_return_activity_function)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(FunctionActivity.this).inflate(R.layout.item_rv_function, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FunctionActivity.this,PreviewActivity.class));
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
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_function);
            }
        }
    }
}
