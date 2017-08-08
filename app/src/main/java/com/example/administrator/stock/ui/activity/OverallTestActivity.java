package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class OverallTestActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_overall)
    LinearLayout mLlStatusActivityOverall;
    @BindView(R.id.rl_return_activity_overall)
    RelativeLayout mRlReturnActivityOverall;
    @BindView(R.id.btn_test)
    Button mBtnTest;
    @BindView(R.id.rv_1)
    RecyclerView mRv1;
    @BindView(R.id.rv_2)
    RecyclerView mRv2;
    @BindView(R.id.rv_3)
    RecyclerView mRv3;
    @BindView(R.id.rv_4)
    RecyclerView mRv4;
    @BindView(R.id.ll_time)
    LinearLayout mLlTime;
    @BindView(R.id.tv_cancle)
    TextView mTvCancle;
    @BindView(R.id.tv_sure)
    TextView mTvSure;
    @BindView(R.id.rl_all)
    RelativeLayout mRlAll;
    @BindView(R.id.ll_showtime)
    LinearLayout mLlShowtime;
    private ArrayList<Integer> listyear,listmouth;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRlAll.setVisibility(View.GONE);
        listyear = new ArrayList<>();
        listmouth = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listyear.add(2015+i);

        }
        for (int i = 0; i <12; i++) {
            listmouth.add(1+i);
        }
        mRv2.setLayoutManager(new LinearLayoutManager(this));
        mRv2.setAdapter(new MyAdapter2());
        mRv4.setLayoutManager(new LinearLayoutManager(this));
        mRv4.setAdapter(new MyAdapter2());
        mRv1.setLayoutManager(new LinearLayoutManager(this));
        mRv1.setAdapter(new MyAdapter());
        mRv3.setLayoutManager(new LinearLayoutManager(this));
        mRv3.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_overall_test;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityOverall;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.rl_return_activity_overall, R.id.btn_test, R.id.tv_cancle, R.id.tv_sure,R.id.ll_showtime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_overall:
                finish();
                break;
            case R.id.btn_test:
                startActivity(new Intent(this,ReportActivity.class));
                break;
            case R.id.tv_cancle:
                mRlAll.setVisibility(View.GONE);
                break;
            case R.id.tv_sure:
                mRlAll.setVisibility(View.GONE);
                break;
            case R.id.ll_showtime:
                mRlAll.setVisibility(View.VISIBLE);
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(OverallTestActivity.this).inflate(R.layout.item_timeyear, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView.setText(listyear.get(position)+"年");


        }

        @Override
        public int getItemCount() {
            return listyear.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
           private TextView mView;


            public ViewHolder(View itemView) {
                super(itemView);
                mView = (TextView) itemView.findViewById(R.id.tv_year);


            }
        }
    }
    class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(OverallTestActivity.this).inflate(R.layout.item_timemouth, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView.setText(listmouth.get(position)+"月");


        }

        @Override
        public int getItemCount() {
            return listmouth.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mView;


            public ViewHolder(View itemView) {
                super(itemView);
                mView = (TextView) itemView.findViewById(R.id.tv_mouth);


            }
        }
    }
}
