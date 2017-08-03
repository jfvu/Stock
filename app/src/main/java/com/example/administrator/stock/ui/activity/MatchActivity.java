package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.MatchSharePop;
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
    private WindowManager.LayoutParams lp;
    private Window window;
    private MatchSharePop mMatchSharePop;

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
            holder.mShareBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        openPop();
                    }
                }
            });
            holder.mList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MatchActivity.this,ListActivity.class));
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
                private CheckBox mShareBox;
                private LinearLayout mList;

            public ViewHolder(View itemView) {
                super(itemView);
                mView = (TextView) itemView.findViewById(R.id.tv_tag_item_rv_match);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_match);
                mShareBox = (CheckBox) itemView.findViewById(R.id.cb_share_item_rv_match);
                mList = (LinearLayout) itemView.findViewById(R.id.ll_list_item_rv_match);
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
    private void openPop(){
        mMatchSharePop = new MatchSharePop(MatchActivity.this,onClickListener);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mMatchSharePop.setTouchable(true);
        mMatchSharePop.setFocusable(true);
        mMatchSharePop.setBackgroundDrawable(new BitmapDrawable());
        mMatchSharePop.setOutsideTouchable(true);



        mMatchSharePop.showAtLocation(this.findViewById(R.id.ll_all_activity_match), Gravity.BOTTOM,0,0);
        mMatchSharePop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {

                lp.alpha = 1f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);
            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_qq_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "qq", Toast.LENGTH_SHORT).show();
                case R.id.ll_wx_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "微信", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_wb_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "微博", Toast.LENGTH_SHORT).show();
                case R.id.ll_space_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "空间", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_friend_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "朋友圈", Toast.LENGTH_SHORT).show();
                case R.id.ll_copy_ms:
                    mMatchSharePop.dismiss();
                    Toast.makeText(MatchActivity.this, "复制链接", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_cancle_matchshare:
                    mMatchSharePop.dismiss();
                    break;

            }
        }
    };
}
