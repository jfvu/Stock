package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.adapter.MainFragmentAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_main)
    LinearLayout mLlStatusActivityMain;
    @BindView(R.id.tl_activity_main)
    TabLayout mTlActivityMain;
    @BindView(R.id.vp_activity_main)
    ViewPager mVpActivityMain;
    private MainFragmentAdapter mMainFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mMainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(),getApplication());
        mVpActivityMain.setAdapter(mMainFragmentAdapter);
        mTlActivityMain.setupWithViewPager(mVpActivityMain);

        mTlActivityMain.getTabAt(0).setCustomView(tab_icon("首页",R.drawable.select_main));
        mTlActivityMain.getTabAt(1).setCustomView(tab_icon("行情",R.drawable.select_price));
        mTlActivityMain.getTabAt(2).setCustomView(tab_icon("消息",R.drawable.select_message));
        mTlActivityMain.getTabAt(3).setCustomView(tab_icon("选股",R.drawable.select_stock));
        mTlActivityMain.getTabAt(4).setCustomView(tab_icon("公式",R.drawable.select_formula));
        //tlActivityMain.setTabTextColors(Color.parseColor("#40242424"),Color.parseColor("#121212"));
        mTlActivityMain.setTabGravity(TabLayout.GRAVITY_FILL);
        mVpActivityMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTlActivityMain));
        mTlActivityMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVpActivityMain));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMain;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }
    private View tab_icon(String name, int icon){
        View view = LayoutInflater.from(this).inflate(R.layout.tablayout,null);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(name);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_tab);
        imageView.setImageResource(icon);
        return view;
    }
}
