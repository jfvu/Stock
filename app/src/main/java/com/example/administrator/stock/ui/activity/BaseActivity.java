package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.stock.ui.MainActivity;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/28.
 */

public abstract class BaseActivity extends AutoLayoutActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR).init();
        ViewGroup.LayoutParams params = getStatusParams().getLayoutParams();
        params.height = getStatusBarHeight();
        getStatusParams().setBackgroundColor(color());

    }



    protected abstract void initData();

    protected abstract void initView();

    protected void init(Bundle savedInstanceState) {

    }

    protected abstract int getLayoutId();
    protected abstract LinearLayout getStatusParams();
    protected abstract int color();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ImmersionBar.with(this).destroy();
    }

    protected void startActivity(Class<MainActivity> clz, boolean isFinish) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
        if (isFinish) finish();
    }

    protected void showTaost(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public int getStatusBarHeight(){
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0){
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
