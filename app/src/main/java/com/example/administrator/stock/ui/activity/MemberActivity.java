package com.example.administrator.stock.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.MemberPop;

import butterknife.BindView;
import butterknife.OnClick;

public class MemberActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_member)
    LinearLayout mLlStatusActivityMember;
    @BindView(R.id.img_return_activity_member)
    ImageView mImgReturnActivityMember;
    @BindView(R.id.ll_vip3_activity_member)
    LinearLayout mLlVip3ActivityMember;
    @BindView(R.id.ll_vip4_activity_member)
    LinearLayout mLlVip4ActivityMember;
    @BindView(R.id.ll_vip1_activity_member)
    LinearLayout mLlVip1ActivityMember;
    @BindView(R.id.ll_vip2_activity_member)
    LinearLayout mLlVip2ActivityMember;
    private MemberPop mMemberPop;
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
        return R.layout.activity_member;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityMember;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_member, R.id.ll_vip3_activity_member, R.id.ll_vip4_activity_member, R.id.ll_vip1_activity_member, R.id.ll_vip2_activity_member})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_member:
                finish();
                break;
            case R.id.ll_vip3_activity_member:
                openPop();
                break;
            case R.id.ll_vip4_activity_member:
                openPop();
                break;
            case R.id.ll_vip1_activity_member:
                openPop();
                break;
            case R.id.ll_vip2_activity_member:
                openPop();
                break;
        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_sure_pop_member:
                    mMemberPop.dismiss();
                    break;

            }
        }
    };
private void openPop(){
    mMemberPop = new MemberPop(MemberActivity.this,onClickListener);
    window = this.getWindow();
    lp = this.getWindow()
            .getAttributes();
    lp.alpha = 0.4f;
    this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    this.getWindow().setAttributes(lp);
    mMemberPop.setTouchable(true);
    mMemberPop.setFocusable(false);
    mMemberPop.setBackgroundDrawable(new BitmapDrawable());
    mMemberPop.setOutsideTouchable(true);



    mMemberPop.showAtLocation(this.findViewById(R.id.rl_activity_member),Gravity.BOTTOM,0,0);
    mMemberPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

        // 在dismiss中恢复透明度
        public void onDismiss() {

            lp.alpha = 1f;
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.setAttributes(lp);
        }
    });
}

}
