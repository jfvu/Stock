package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SeachActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_seach)
    LinearLayout mLlStatusActivitySeach;
    @BindView(R.id.tv_cancel_activity_seach)
    TextView mTvCancelActivitySeach;
    @BindView(R.id.rl_seach_activity_seach)
    RelativeLayout mRlSeachActivitySeach;
    @BindView(R.id.tv_heat_activit_seach)
    TextView mTvHeatActivitSeach;
    @BindView(R.id.rv_heat_activity_seach)
    RecyclerView mRvHeatActivitySeach;
    @BindView(R.id.tv_history_activity_seach)
    TextView mTvHistoryActivitySeach;
    @BindView(R.id.img_delete_activity_seach)
    ImageView mImgDeleteActivitySeach;
    @BindView(R.id.rv_history_activity_seach)
    RecyclerView mRvHistoryActivitySeach;
    private List<String> mList1,mList2;
    private MyAdapter mAdapter1,mAdapter2;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0){
                mList1.add("热门搜索"+i);}else {mList1.add(""+i);}
        }
        for (int i = 0; i < 12; i++) {
            if (i%2 == 0){
                mList2.add("历史搜索"+i);}else {mList2.add(""+i);}
        }
        mAdapter1= new MyAdapter(mList1);
        mAdapter2 = new MyAdapter(mList2);

        mRvHeatActivitySeach.setLayoutManager(new GridLayoutManager(this,4));
        mRvHeatActivitySeach.setAdapter(mAdapter1);
        mRvHistoryActivitySeach.setLayoutManager(new MyLayoutManager());
        mRvHistoryActivitySeach.setAdapter(mAdapter2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seach;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivitySeach;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ffffff");
    }



    @OnClick({R.id.tv_cancel_activity_seach, R.id.img_delete_activity_seach})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel_activity_seach:
                finish();
                break;
            case R.id.img_delete_activity_seach:
                mList2.clear();
                mAdapter2.notifyDataSetChanged();
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public MyAdapter(List<String> list) {
            mList = list;
        }

        private List<String> mList;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(SeachActivity.this).inflate(R.layout.item_rv_seach, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView1.setText(mList.get(position));
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SeachActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private TextView mView1;
            private RelativeLayout mLayout;


            public ViewHolder(View itemView) {
                super(itemView);
                mView1 = (TextView) itemView.findViewById(R.id.tv_item_rv_seach);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_item_rv_seach);
            }
        }
    }
    class MyLayoutManager extends RecyclerView.LayoutManager{
        @Override
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.WRAP_CONTENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
        }
        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            detachAndScrapAttachedViews(recycler);

            int sumWidth = getWidth();

            int curLineWidth = 0, curLineTop = 0;
            int lastLineMaxHeight = 0;
            for (int i = 0; i < getItemCount(); i++) {
                View view = recycler.getViewForPosition(i);

                addView(view);
                measureChildWithMargins(view, 0, 0);
                int width = getDecoratedMeasuredWidth(view);
                int height = getDecoratedMeasuredHeight(view);

                curLineWidth += width;
                if (curLineWidth <= sumWidth) {//不需要换行
                    layoutDecorated(view, curLineWidth - width, curLineTop, curLineWidth, curLineTop + height);
                    //比较当前行多有item的最大高度
                    lastLineMaxHeight = Math.max(lastLineMaxHeight, height);
                } else {//换行
                    curLineWidth = width;
                    if (lastLineMaxHeight == 0) {
                        lastLineMaxHeight = height;
                    }
                    //记录当前行top
                    curLineTop += lastLineMaxHeight;

                    layoutDecorated(view, 0, curLineTop, width, curLineTop + height);
                    lastLineMaxHeight = height;
                }
            }

        }
    }
}
