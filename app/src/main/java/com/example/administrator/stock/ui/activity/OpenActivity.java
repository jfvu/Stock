package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class OpenActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_open)
    LinearLayout mLlStatusActivityOpen;
    @BindView(R.id.img_return_activity_open)
    RelativeLayout mImgReturnActivityOpen;
    @BindView(R.id.rv_activity_open)
    RecyclerView mRvActivityOpen;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityOpen.setLayoutManager( new LinearLayoutManager(this));
        mRvActivityOpen.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_open;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityOpen;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick(R.id.img_return_activity_open)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(OpenActivity.this).inflate(R.layout.item_rv_open, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OpenActivity.this, ""+position, Toast.LENGTH_SHORT).show();
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
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_open);


            }
        }
    }
}
