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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.WalletPop;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_wallet)
    LinearLayout mLlStatusActivityWallet;
    @BindView(R.id.img_return_activity_wallet)
    ImageView mImgReturnActivityWallet;
    @BindView(R.id.btn_recharge_activity_wallet)
    Button mBtnRechargeActivityWallet;
    @BindView(R.id.rv_activity_wallet)
    RecyclerView mRvActivityWallet;
    private WalletPop mWalletPop;
    private WindowManager.LayoutParams lp;
    private Window window;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRvActivityWallet.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityWallet.setAdapter(new MyAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityWallet;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_wallet, R.id.btn_recharge_activity_wallet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_wallet:
                finish();
                break;
            case R.id.btn_recharge_activity_wallet:
                openPop();
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(WalletActivity.this).inflate(R.layout.item_rv_wallet, parent, false);
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
    private void openPop(){
        mWalletPop = new WalletPop(WalletActivity.this,onClickListener);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mWalletPop.setTouchable(true);
        mWalletPop.setFocusable(true);
        mWalletPop.setBackgroundDrawable(new BitmapDrawable());
        mWalletPop.setOutsideTouchable(true);



        mWalletPop.showAtLocation(this.findViewById(R.id.ll_activity_wallet), Gravity.CENTER,0,0);
        mWalletPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
                case R.id.ll_wx_wallet:
                    mWalletPop.dismiss();
                case R.id.ll_zfb_wallet:
                    mWalletPop.dismiss();
                    break;
                case R.id.img_close_wallet:
                    mWalletPop.dismiss();
                    break;

            }
        }
    };
}
