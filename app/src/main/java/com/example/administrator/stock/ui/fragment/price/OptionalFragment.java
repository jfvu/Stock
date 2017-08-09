package com.example.administrator.stock.ui.fragment.price;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.StockActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.example.administrator.stock.ui.view.OptionalPop;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.kareluo.ui.OptionMenu;
import me.kareluo.ui.OptionMenuView;
import me.kareluo.ui.PopupMenuView;
import me.kareluo.ui.PopupView;

/**
 * Created by Administrator on 2017/7/29.
 */

public class OptionalFragment extends BaseFragment {
    @BindView(R.id.rv_center_fragment_optional)
    RecyclerView mRvCenterFragmentOptional;
    @BindView(R.id.rb_1_fragment_optional)
    RadioButton mRb1FragmentOptional;
    @BindView(R.id.rb_2_fragment_optional)
    RadioButton mRb2FragmentOptional;
    @BindView(R.id.rb_3_fragment_optional)
    RadioButton mRb3FragmentOptional;
    @BindView(R.id.rb_4_fragment_optional)
    RadioButton mRb4FragmentOptional;
    @BindView(R.id.rb_5_fragment_optional)
    RadioButton mRb5FragmentOptional;
    @BindView(R.id.rb_6_fragment_optional)
    RadioButton mRb6FragmentOptional;
    @BindView(R.id.ll_updown_fragment_optional)
    LinearLayout mLlUpdownFragmentOptional;
    @BindView(R.id.rv_fragment_optional)
    RecyclerView mRvFragmentOptional;
    Unbinder unbinder;
    @BindView(R.id.tv_delect)
    TextView mTvDelect;
    Unbinder unbinder1;
    private List<Center> mCenters;
    private PopupMenuView mMenuView;
    private boolean flag = false;
    private MyAdapter mMyAdapter;
    private OptionalPop mOptionalPop;
    private WindowManager.LayoutParams lp;
    private Window window;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_optional;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRb1FragmentOptional.setChecked(true);
        mCenters = new ArrayList<>();
        Center center1 = new Center("上证指数", "3105.54", "+2.09", "+0.09%", Color.parseColor("#ff0000"));
        Center center2 = new Center("深证成指", "9794.89", "+64.56", "+0.66%", Color.parseColor("#ff0000"));
        Center center3 = new Center("创业板", "3486.51", "-20.89", "-0.84%", Color.parseColor("#7ED321"));
        mCenters.add(center1);
        mCenters.add(center2);
        mCenters.add(center3);

        mRvCenterFragmentOptional.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRvCenterFragmentOptional.setAdapter(new MyCenterAdapter());
        mMenuView = new PopupMenuView(getActivity(), R.menu.menu_pop, new MenuBuilder(getActivity()));
        mMenuView.setOrientation(LinearLayout.HORIZONTAL);
        mMenuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
            @Override
            public boolean onOptionMenuClick(int position, OptionMenu menu) {
                Toast.makeText(getActivity(), "" + menu.getTitle(), Toast.LENGTH_SHORT).show();
                if (menu.getTitle().equals("多选")) {
                    flag = true;
                    mMyAdapter.notifyDataSetChanged();
                    mTvDelect.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
        mRvFragmentOptional.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMyAdapter = new MyAdapter();
        mRvFragmentOptional.setAdapter(mMyAdapter);
        if (!flag){
            mTvDelect.setVisibility(View.GONE);
        }

    }



    @OnClick({R.id.tv_delect, R.id.ll_updown_fragment_optional})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_delect:
                openPop();
                break;
            case R.id.ll_updown_fragment_optional:
                break;
        }
    }

    class MyCenterAdapter extends RecyclerView.Adapter<MyCenterAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_center_hushen, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView1.setText(mCenters.get(position).getTv1());
            holder.mView2.setText(mCenters.get(position).getTv2());
            holder.mView3.setText(mCenters.get(position).getTv3());
            holder.mView4.setText(mCenters.get(position).getTv4());

            holder.mView2.setTextColor(mCenters.get(position).getColor());
            holder.mView3.setTextColor(mCenters.get(position).getColor());
            holder.mView4.setTextColor(mCenters.get(position).getColor());

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mCenters.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;
            private TextView mView1, mView2, mView3, mView4;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_list_price);
                mView1 = (TextView) itemView.findViewById(R.id.tv_1_center_price);
                mView2 = (TextView) itemView.findViewById(R.id.tv_2_center_price);
                mView3 = (TextView) itemView.findViewById(R.id.tv_3_center_price);
                mView4 = (TextView) itemView.findViewById(R.id.tv_4_center_price);

            }
        }
    }

    class Center {
        private String tv1;
        private String tv2;
        private String tv3;
        private String tv4;
        private int color;

        public String getTv1() {
            return tv1;
        }

        public String getTv2() {
            return tv2;
        }

        public String getTv3() {
            return tv3;
        }

        public String getTv4() {
            return tv4;
        }

        public int getColor() {
            return color;
        }

        public Center(String tv1, String tv2, String tv3, String tv4, int color) {
            this.tv1 = tv1;
            this.tv2 = tv2;
            this.tv3 = tv3;
            this.tv4 = tv4;
            this.color = color;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_optional, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            if (!flag) {
                holder.mBox.setVisibility(View.GONE);
                holder.mLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), StockActivity.class));
                    }
                });
            } else {
                holder.mBox.setVisibility(View.VISIBLE);
            }

            holder.mLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mMenuView.setMenuItems(Arrays.asList(
                            new OptionMenu("置顶"), new OptionMenu("置底"),
                            new OptionMenu("删除"), new OptionMenu("K线图"), new OptionMenu("分组"), new OptionMenu("多选")));
                    mMenuView.show(holder.mView);
                    mMenuView.setSites(PopupView.SITE_RIGHT);
                    return false;
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
        mOptionalPop = new OptionalPop(getActivity(),onClickListener);
        window = getActivity().getWindow();
        lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
        mOptionalPop.setTouchable(true);
        mOptionalPop.setFocusable(true);
        mOptionalPop.setBackgroundDrawable(new BitmapDrawable());
        mOptionalPop.setOutsideTouchable(true);



        mOptionalPop.showAtLocation(getActivity().findViewById(R.id.rl_all_activity_main), Gravity.CENTER,0,0);
        mOptionalPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
                    mOptionalPop.dismiss();
                    flag = false;
                    mTvDelect.setVisibility(View.GONE);
                    mMyAdapter.notifyDataSetChanged();
                case R.id.btn_yes_pop_match:
                    mOptionalPop.dismiss();
                    flag = false;
                    mTvDelect.setVisibility(View.GONE);
                    mMyAdapter.notifyDataSetChanged();
                    break;


            }
        }
    };
}
