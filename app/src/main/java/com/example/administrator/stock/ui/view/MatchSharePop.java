package com.example.administrator.stock.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MatchSharePop extends PopupWindow {
    private Context context;
    private View view;


    private Button mCancle;
    private LinearLayout mQQ,mWX,mWB,mSPACE,mFRIEND,mCOPY;


    public MatchSharePop(Context context, View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_matchshare,null);

        mCancle = (Button) view.findViewById(R.id.btn_cancle_matchshare);
        mQQ = (LinearLayout) view.findViewById(R.id.ll_qq_ms);
        mWX = (LinearLayout) view.findViewById(R.id.ll_wx_ms);
        mWB = (LinearLayout) view.findViewById(R.id.ll_wb_ms);
        mSPACE = (LinearLayout) view.findViewById(R.id.ll_space_ms);
        mFRIEND = (LinearLayout) view.findViewById(R.id.ll_friend_ms);
        mCOPY = (LinearLayout) view.findViewById(R.id.ll_copy_ms);
        //AutoUtils.autoSize(view);
        mCancle.setOnClickListener(onClickListener);
        mQQ.setOnClickListener(onClickListener);
        mWX.setOnClickListener(onClickListener);
        mWB.setOnClickListener(onClickListener);
        mSPACE.setOnClickListener(onClickListener);
        mFRIEND.setOnClickListener(onClickListener);
        mCOPY.setOnClickListener(onClickListener);

        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);
    }
}
