package com.example.administrator.stock.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class BackPop extends PopupWindow {
    private Context context;
    private View view;


   private TextView back,buy,cancle;


    public BackPop(Context context, View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_back,null);

        back = (TextView) view.findViewById(R.id.tv_back);
        buy = (TextView) view.findViewById(R.id.tv_buy);
        cancle = (TextView) view.findViewById(R.id.tv_cancle);

        //AutoUtils.autoSize(view);
        back.setOnClickListener(onClickListener);
        buy.setOnClickListener(onClickListener);
        cancle.setOnClickListener(onClickListener);
        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);
    }
}
