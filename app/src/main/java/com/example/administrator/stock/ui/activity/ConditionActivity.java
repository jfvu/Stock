package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.ConditionPop;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ConditionActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_condition)
    LinearLayout mLlStatusActivityCondition;
    @BindView(R.id.img_return_activity_condition)
    ImageView mImgReturnActivityCondition;
    @BindView(R.id.tv_finish)
    TextView mTvFinish;
    @BindView(R.id.ll_updown_activity_condition)
    LinearLayout mLlUpdownActivityCondition;
    @BindView(R.id.rv_activity_condition)
    RecyclerView mRvActivityCondition;
    private boolean flag = true;
    private ConditionPop mConditionPop;
    private WindowManager.LayoutParams lp;
    private Window window;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityCondition.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityCondition.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_condition;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCondition;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_condition, R.id.tv_finish, R.id.ll_updown_activity_condition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_condition:
                finish();
                break;
            case R.id.tv_finish:
                if (flag){
                    mTvFinish.setText("确定");
                    flag = false;
                        openPop();
                }else {
                    mTvFinish.setText("编辑");
                    flag = true;
                    finish();
                }
                break;
            case R.id.ll_updown_activity_condition:
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ConditionActivity.this).inflate(R.layout.item_rv_optional, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ConditionActivity.this, ""+position, Toast.LENGTH_SHORT).show();
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
            private CheckBox mBox;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_price);
                mView = (TextView) itemView.findViewById(R.id.tv_center_optional);
                mBox = (CheckBox) itemView.findViewById(R.id.cb_item_rv_optional);

            }
        }
    }
    private void openPop(){
        mConditionPop = new ConditionPop(this,onClickListener);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mConditionPop.setTouchable(true);
        mConditionPop.setFocusable(true);
        mConditionPop.setBackgroundDrawable(new BitmapDrawable());
        mConditionPop.setOutsideTouchable(true);



        mConditionPop.showAtLocation(this.findViewById(R.id.ll_all_activity_condition), Gravity.CENTER,0,0);
        mConditionPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {

                lp.alpha = 1f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);
            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_no_pop_match:
                    mConditionPop.dismiss();
                case R.id.btn_yes_pop_match:
                    mConditionPop.dismiss();
                    break;


            }
        }
    };
}
