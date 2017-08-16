package com.example.administrator.stock.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/31.
 */

public class AiPop extends PopupWindow {
    private Context context;
    private View view;
    private ArrayList<String> mList;
    private RecyclerView mRecyclerView;
    private View.OnClickListener onClickListener;



    public AiPop(Context context, View.OnClickListener onClickListener,ArrayList<String> mList){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_ai,null);
        this.mList = mList;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_pop);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(new MyAdapter());
        this.onClickListener = onClickListener;
        //AutoUtils.autoSize(view);
      /*  back.setOnClickListener(onClickListener);
        buy.setOnClickListener(onClickListener);
        cancle.setOnClickListener(onClickListener);*/
        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.item_rv_pop, parent, false);
            AutoUtils.autoSize(view1);
            return new ViewHolder(view1);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mTextView.setText(mList.get(position));
            holder.mLayout.setTag(position);
            holder.mLayout.setOnClickListener(onClickListener);

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mTextView;
            private LinearLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.tv_show_pop);
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_pop);

            }
        }
    }
}
