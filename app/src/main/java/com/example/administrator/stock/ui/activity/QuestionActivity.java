package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.QuestionPop;

import butterknife.BindView;
import butterknife.OnClick;

public class QuestionActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_question)
    LinearLayout mLlStatusActivityQuestion;
    @BindView(R.id.img_return_activity_question)
    RelativeLayout mImgReturnActivityQuestion;
    @BindView(R.id.btn_submit_activity_question)
    Button mBtnSubmitActivityQuestion;
    private QuestionPop mQuestionPop;
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
        return R.layout.activity_question;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityQuestion;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_question, R.id.btn_submit_activity_question})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_question:
                finish();
                break;
            case R.id.btn_submit_activity_question:
                openPop();
                break;
        }
    }
    private void openPop(){
        mQuestionPop = new QuestionPop(this,onClickListener);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mQuestionPop.setTouchable(true);
        mQuestionPop.setFocusable(true);
        mQuestionPop.setBackgroundDrawable(new BitmapDrawable());
        mQuestionPop.setOutsideTouchable(true);



        mQuestionPop.showAtLocation(this.findViewById(R.id.ll_all_activity_question), Gravity.CENTER,0,0);
        mQuestionPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
                    mQuestionPop.dismiss();
                case R.id.btn_yes_pop_match:
                    mQuestionPop.dismiss();
                    finish();
                    break;


            }
        }
    };
}
