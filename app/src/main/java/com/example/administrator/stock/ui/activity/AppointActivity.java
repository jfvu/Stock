package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AppointActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_appoint)
    LinearLayout mLlStatusActivityAppoint;
    @BindView(R.id.img_return_activity_appoint)
    RelativeLayout mImgReturnActivityAppoint;
    @BindView(R.id.img_open1_activity_appoint)
    RelativeLayout mImgOpen1ActivityAppoint;
    @BindView(R.id.btn_change1_activity_appoint)
    Button mBtnChange1ActivityAppoint;
    @BindView(R.id.img_open2_activity_appoint)
    RelativeLayout mImgOpen2ActivityAppoint;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    private SpinerPopWindow<String> mSpinerPopWindow, mSpinerPopWindow1,mSpinerPopWindow2;
    private int i;


    private List<String> list, list1,list2;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        list1 = new ArrayList<>();
        list1.add("不卖涨停股票");
        list1.add("不卖跌停股票");
        list = new ArrayList<>();
        list.add("不买涨停股票");
        list.add("不买跌停股票");
        list.add("不买上市n周内股票");
        list.add("不买上市n个月内股票");
        list.add("不买上市n年内股票");
        list.add("不买涨幅超过n%");
        list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list2.add(String.valueOf(i+1));
        }
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list, itemClickListener);
        mSpinerPopWindow.setOnDismissListener(dismissListener);
        mSpinerPopWindow1 = new SpinerPopWindow<String>(this, list1, itemClickListener1);
        mSpinerPopWindow1.setOnDismissListener(dismissListener);
        mSpinerPopWindow2 = new SpinerPopWindow<String>(this, list2, itemClickListener2);
        mSpinerPopWindow2.setOnDismissListener(dismissListener);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_appoint;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAppoint;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_appoint, R.id.img_open1_activity_appoint, R.id.btn_change1_activity_appoint, R.id.img_open2_activity_appoint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_appoint:
                finish();
                break;
            case R.id.img_open1_activity_appoint:
                mSpinerPopWindow.setWidth(mImgOpen1ActivityAppoint.getWidth());
                mSpinerPopWindow.showAsDropDown(mImgOpen1ActivityAppoint);
                break;
            case R.id.btn_change1_activity_appoint:
                break;
            case R.id.img_open2_activity_appoint:
                mSpinerPopWindow1.setWidth(mImgOpen2ActivityAppoint.getWidth());
                mSpinerPopWindow1.showAsDropDown(mImgOpen2ActivityAppoint);
                break;
        }
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0 || position  == 1){
            mSpinerPopWindow.dismiss();
            mTv1.setText(list.get(position));}
            else {
                mSpinerPopWindow.dismiss();
                mSpinerPopWindow2.setWidth(mImgOpen1ActivityAppoint.getWidth());
                mSpinerPopWindow2.showAsDropDown(mImgOpen1ActivityAppoint);
                mTv1.setText(list.get(position));
                i = position;
            }
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener1 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow1.dismiss();
            mTv2.setText(list1.get(position));
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener2 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow2.dismiss();
            //mTv1.setText(list2.get(position));
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
            String[] ns = list.get(i).split("n");
            mTv1.setText(ns[0]+ list2.get(position)+ns[1]);
        }
    };


    private PopupWindow.OnDismissListener dismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            //setTextImage(R.drawable.icon_down);
        }
    };

}
