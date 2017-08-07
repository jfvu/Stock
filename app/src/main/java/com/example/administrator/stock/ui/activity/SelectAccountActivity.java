package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectAccountActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_selectaccount)
    LinearLayout mLlStatusActivitySelectaccount;
    @BindView(R.id.img_return_activity_selectaccount)
    RelativeLayout mImgReturnActivitySelectaccount;
    @BindView(R.id.rv_activity_selectaccount)
    RecyclerView mRvActivitySelectaccount;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivitySelectaccount.setLayoutManager(new LinearLayoutManager(this));
        mRvActivitySelectaccount.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_account;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySelectaccount;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick(R.id.img_return_activity_selectaccount)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(SelectAccountActivity.this).inflate(R.layout.item_rv_selectaccount, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
                holder.mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });



        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

                private Button mButton;

            public ViewHolder(View itemView) {
                super(itemView);
                mButton= (Button) itemView.findViewById(R.id.btn_open_item_rv_selectaccount);


            }
        }
    }
}
