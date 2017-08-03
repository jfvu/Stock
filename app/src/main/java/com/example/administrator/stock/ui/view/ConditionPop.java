package com.example.administrator.stock.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class ConditionPop extends PopupWindow {
    private Context context;
    private View view;


    private Button mCancle,mSure;


    public ConditionPop(Context context, View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_condition,null);

        mCancle = (Button) view.findViewById(R.id.btn_no_pop_match);
        mSure = (Button) view.findViewById(R.id.btn_yes_pop_match);

        //AutoUtils.autoSize(view);
        mCancle.setOnClickListener(onClickListener);
        mSure.setOnClickListener(onClickListener);

        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);
    }
}
