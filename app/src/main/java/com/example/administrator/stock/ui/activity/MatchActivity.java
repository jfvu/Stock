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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_match)
    LinearLayout mLlStatusActivityMatch;
    @BindView(R.id.img_return_activity_match)
    ImageView mImgReturnActivityMatch;
    @BindView(R.id.tv_creat_activity_match)
    TextView mTvCreatActivityMatch;
    @BindView(R.id.tv_show_activity_match)
    TextView mTvShowActivityMatch;
    @BindView(R.id.rv_activity_match)
    RecyclerView mRvActivityMatch;
    private List<Match> mList;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        Match match1 = new Match(R.drawable.match_item_tag1,"官方");
        Match match2 = new Match(R.drawable.match_item_tag2,"热门");
        for (int i = 0; i < 4; i++) {
            mList.add(match1);
            mList.add(match2);
        }
        mTvShowActivityMatch.setText(""+mList.size());
        mRvActivityMatch.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityMatch.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMatch;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_match, R.id.tv_creat_activity_match})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_match:
                finish();
                break;
            case R.id.tv_creat_activity_match:
                startActivity(new Intent(MatchActivity.this,CreatMatchActivity.class));
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MatchActivity.this).inflate(R.layout.item_rv_match, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView.setBackgroundResource(mList.get(position).getBg());
            holder.mView.setText(mList.get(position).getName());
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MatchActivity.this,MatchExplainActivity.class));
                }
            });


        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
                private TextView mView;
                private RelativeLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mView = (TextView) itemView.findViewById(R.id.tv_tag_item_rv_match);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_match);

            }
        }
    }
    class Match{
        private int bg;
        private String name;

        public int getBg() {
            return bg;
        }

        public String getName() {
            return name;
        }

        public Match(int bg, String name) {
            this.bg = bg;
            this.name = name;
        }
    }
}
