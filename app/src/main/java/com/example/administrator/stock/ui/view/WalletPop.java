package com.example.administrator.stock.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class WalletPop extends PopupWindow {
    private Context context;
    private View view;


    private LinearLayout mLayoutwx,mLayoutzfb;
    private ImageView mView;

    public WalletPop(Context context, View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_wallet,null);


        mLayoutwx = (LinearLayout) view.findViewById(R.id.ll_wx_wallet);
        mLayoutzfb = (LinearLayout) view.findViewById(R.id.ll_zfb_wallet);
        mView = (ImageView) view.findViewById(R.id.img_close_wallet);

        mLayoutwx.setOnClickListener(onClickListener);
        mLayoutzfb.setOnClickListener(onClickListener);
        mView.setOnClickListener(onClickListener);
        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);

    }
}
