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
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_message)
    LinearLayout mLlStatusActivityMessage;
    @BindView(R.id.img_return_activity_message)
    RelativeLayout mImgReturnActivityMessage;
    @BindView(R.id.rv_activity_message)
    RecyclerView mRvActivityMessage;
    private Intent mIntent;
    private String flag;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityMessage.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityMessage.setAdapter(new MyAdapter());
        mIntent = getIntent();
        flag = mIntent.getStringExtra("MessageActivity");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMessage;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick(R.id.img_return_activity_message)
    public void onViewClicked() {
        finish();
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MessageActivity.this).inflate(R.layout.item_rv_message, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            if (flag!=null&&flag.equals("system")){
            holder.mTextView.setText("系统客服");
            holder.mButton1.setVisibility(View.GONE);
            holder.mButton2.setVisibility(View.GONE);
            holder.mButton3.setVisibility(View.GONE);}
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MessageActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;
            private TextView mTextView;
            private Button mButton1,mButton2,mButton3;


            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_itme_rv_message);
                mTextView = (TextView) itemView.findViewById(R.id.tv_name_item_rv_message);
                mButton1 = (Button) itemView.findViewById(R.id.btn_buy_item_rv_message);
                mButton2 = (Button) itemView.findViewById(R.id.btn_sell_item_rv_message);
                mButton3 = (Button) itemView.findViewById(R.id.btn_price_item_rv_message);
            }
        }
    }
}
