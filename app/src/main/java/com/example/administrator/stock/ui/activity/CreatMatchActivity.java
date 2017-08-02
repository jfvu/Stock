package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.MatchPop;

import butterknife.BindView;
import butterknife.OnClick;

public class CreatMatchActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_creatmatch)
    LinearLayout mLlStatusActivityCreatmatch;
    @BindView(R.id.img_return_activity_creatmatch)
    ImageView mImgReturnActivityCreatmatch;
    @BindView(R.id.rl_class_activity_creatmatch)
    RelativeLayout mRlClassActivityCreatmatch;
    @BindView(R.id.tv_cooperation_activity_creatmatch)
    TextView mTvCooperationActivityCreatmatch;
    @BindView(R.id.btn_next_activity_creatematch)
    Button mBtnNextActivityCreatematch;
    private MatchPop mMatchPop;
    private WindowManager.LayoutParams lp;
    private Window window;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_creat_match;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCreatmatch;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_creatmatch, R.id.rl_class_activity_creatmatch, R.id.tv_cooperation_activity_creatmatch, R.id.btn_next_activity_creatematch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_creatmatch:
                finish();
                break;
            case R.id.rl_class_activity_creatmatch:
                break;
            case R.id.tv_cooperation_activity_creatmatch:
                openPop();
                break;
            case R.id.btn_next_activity_creatematch:
                startActivity(new Intent(this,CreatMatch2Activity.class));
                break;
        }
    }
    private void openPop(){
        mMatchPop = new MatchPop(CreatMatchActivity.this,onClickListener);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mMatchPop.setTouchable(true);
        mMatchPop.setFocusable(true);
        mMatchPop.setBackgroundDrawable(new BitmapDrawable());
        mMatchPop.setOutsideTouchable(true);



        mMatchPop.showAtLocation(this.findViewById(R.id.ll_all_activity_creatmatch), Gravity.CENTER,0,0);
        mMatchPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
                    mMatchPop.dismiss();
                case R.id.btn_yes_pop_match:
                    mMatchPop.dismiss();
                    break;


            }
        }
    };
}
