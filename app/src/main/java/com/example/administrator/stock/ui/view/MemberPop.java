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

public class MemberPop extends PopupWindow {
    private Context context;
    private View view;

    private Button button;

    public MemberPop(Context context,View.OnClickListener onClickListener){
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_member,null);


        button = (Button) view.findViewById(R.id.btn_sure_pop_member);


        button.setOnClickListener(onClickListener);

        this.setOutsideTouchable(true);

        this.setContentView(this.view);
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setFocusable(false);
        ColorDrawable drawable = new ColorDrawable(0000000);
        this.setBackgroundDrawable(drawable);

    }
}
