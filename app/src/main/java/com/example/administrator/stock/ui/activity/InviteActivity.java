package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InviteActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_invite)
    LinearLayout mLlStatusActivityInvite;
    @BindView(R.id.img_return_activity_invite)
    ImageView mImgReturnActivityInvite;
    @BindView(R.id.btn_download_activity_invite)
    Button mBtnDownloadActivityInvite;
    @BindView(R.id.rv_activity_invite)
    RecyclerView mRvActivityInvite;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityInvite.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityInvite.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityInvite;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_return_activity_invite, R.id.btn_download_activity_invite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_invite:
                finish();
                break;
            case R.id.btn_download_activity_invite:
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(InviteActivity.this).inflate(R.layout.item_rv_invite, parent, false);
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
