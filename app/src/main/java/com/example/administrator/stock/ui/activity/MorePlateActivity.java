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

public class MorePlateActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_moreplate)
    LinearLayout mLlStatusActivityMoreplate;
    @BindView(R.id.img_return_activity_moreplate)
    RelativeLayout mImgReturnActivityMoreplate;
    @BindView(R.id.rv_activity_moreplate)
    RecyclerView mRvActivityMoreplate;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityMoreplate.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityMoreplate.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more_plate;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMoreplate;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_moreplate)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MorePlateActivity.this).inflate(R.layout.item_rv_moreplate, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(MorePlateActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MorePlateActivity.this,PlateActivity.class));
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
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_moreplate);
            }
        }
    }
}
