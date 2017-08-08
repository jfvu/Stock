package com.example.administrator.stock.ui.fragment.operater;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.view.BackPop;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/8.
 */

public class BackFragment extends BaseFragment {
    @BindView(R.id.rl_fragment_back)
    RecyclerView mRlFragmentBack;
    Unbinder unbinder;
    private BackPop mBackPop;
    private WindowManager.LayoutParams lp;
    private Window window;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_back;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRlFragmentBack.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRlFragmentBack.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_back, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        openPop();
                }
            });



        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private LinearLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (LinearLayout) itemView.findViewById(R.id.ll_item_rv_back);
            }
        }
    }
    private void openPop(){
        mBackPop = new BackPop(getActivity(),onClickListener);
        window = getActivity().getWindow();
        lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
        mBackPop.setTouchable(true);
        mBackPop.setFocusable(true);
        mBackPop.setBackgroundDrawable(new BitmapDrawable());
        mBackPop.setOutsideTouchable(true);



        mBackPop.showAtLocation(getActivity().findViewById(R.id.ll_all_back), Gravity.CENTER,0,0);
        mBackPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
                case R.id.tv_back:
                    mBackPop.dismiss();
                case R.id.tv_buy:
                    mBackPop.dismiss();
                    break;
                case R.id.tv_cancle:
                    mBackPop.dismiss();
                    break;

            }
        }
    };
}
