package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class HistoryDealActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_historydeal)
    LinearLayout mLlStatusActivityHistorydeal;
    @BindView(R.id.rl_return_activity_historydeal)
    RelativeLayout mRlReturnActivityHistorydeal;
    @BindView(R.id.rv_activity_historydeal)
    RecyclerView mRvActivityHistorydeal;
    @BindView(R.id.ll_time_1)
    LinearLayout mLlTime1;
    @BindView(R.id.ll_time_2)
    LinearLayout mLlTime2;
    @BindView(R.id.tv_time_1)
    TextView mTvTime1;
    @BindView(R.id.tv_time_2)
    TextView mTvTime2;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityHistorydeal.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityHistorydeal.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history_deal;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityHistorydeal;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }




    @OnClick({R.id.rl_return_activity_historydeal, R.id.ll_time_1, R.id.ll_time_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_return_activity_historydeal:
                finish();
                break;
            case R.id.ll_time_1:
                showTimePicker(mTvTime1);
                break;
            case R.id.ll_time_2:
                showTimePicker(mTvTime2);
                break;
        }
    }

    private void showTimePicker(final TextView view) {
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                view.setText(getTime(date));
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                //.setCancelText("Cancel")//取消按钮文字
                //.setSubmitText("Sure")//确认按钮文字
                .setContentSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                //.setTitleText("Title")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                //.etTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLACK)//确定按钮文字颜色
                .setCancelColor(Color.BLACK)//取消按钮文字颜色
                .setTextColorCenter(Color.BLACK)
                .setTitleBgColor(Color.parseColor("#ffffff"))//标题背景颜色 Night mode
                .setBgColor(Color.parseColor("#ffffff"))//滚轮背景颜色 Night mode
                //.setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                //.setRangDate(startDate,endDate)//起始终止年月日设定
                .setLabel("年","月","日","","","")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();

        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        time=time.substring(0, time.lastIndexOf(' '));
        return time;
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(HistoryDealActivity.this).inflate(R.layout.item_rv_deal, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {



        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {


            public ViewHolder(View itemView) {
                super(itemView);

            }
        }
    }
}
