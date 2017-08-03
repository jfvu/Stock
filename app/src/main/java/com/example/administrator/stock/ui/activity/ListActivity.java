package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ListActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_list)
    LinearLayout mLlStatusActivityList;
    @BindView(R.id.img_return_activity_list)
    ImageView mImgReturnActivityList;
    @BindView(R.id.rb_all_activity_list)
    RadioButton mRbAllActivityList;
    @BindView(R.id.rb_week_activity_list)
    RadioButton mRbWeekActivityList;
    @BindView(R.id.rb_day_activity_list)
    RadioButton mRbDayActivityList;
    @BindView(R.id.tv_set_activity_list)
    TextView mTvSetActivityList;
    @BindView(R.id.rv_activity_list)
    RecyclerView mRvActivityList;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRbAllActivityList.setChecked(true);
        mRvActivityList.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityList.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityList;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_list, R.id.tv_set_activity_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_list:
                finish();
                break;
            case R.id.tv_set_activity_list:
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ListActivity.this).inflate(R.layout.item_rv_list, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView.setText("0"+position);
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ListActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                }
            });



        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;
            private TextView mView;


            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_list);
                mView = (TextView) itemView.findViewById(R.id.tv_number_item_rv_list);


            }
        }
    }
}
