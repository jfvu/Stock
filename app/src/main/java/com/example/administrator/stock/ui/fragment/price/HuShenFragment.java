package com.example.administrator.stock.ui.fragment.price;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.MorePlateActivity;
import com.example.administrator.stock.ui.activity.PlateActivity;
import com.example.administrator.stock.ui.activity.StockActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HuShenFragment extends BaseFragment {
    @BindView(R.id.rv_center_fragment_hushen)
    RecyclerView mRvCenterFragmentHushen;
    @BindView(R.id.img_listopen_fragment_hushen)
    ImageView mImgListopenFragmentHushen;
    @BindView(R.id.rl_listopen_fragment_hushen)
    RelativeLayout mRlListopenFragmentHushen;
    @BindView(R.id.img_listmore_fragment_hushen)
    ImageView mImgListmoreFragmentHushen;
    @BindView(R.id.rl_list_fragment_hushen)
    RelativeLayout mRlListFragmentHushen;
    @BindView(R.id.rv_list_fragment_hushen)
    RecyclerView mRvListFragmentHushen;
    @BindView(R.id.img_view_list_fragment_hushen)
    ImageView mImgViewListFragmentHushen;
    @BindView(R.id.img_riseopen_fragment_hushen)
    ImageView mImgRiseopenFragmentHushen;
    @BindView(R.id.rl_riseopen_fragment_hushen)
    RelativeLayout mRlRiseopenFragmentHushen;
    @BindView(R.id.img_risemore_fragment_hushen)
    ImageView mImgRisemoreFragmentHushen;
    @BindView(R.id.rv_rise_fragment_hushen)
    RecyclerView mRvRiseFragmentHushen;
    @BindView(R.id.img_view_rise_fragment_hushen)
    ImageView mImgViewRiseFragmentHushen;
    @BindView(R.id.img_fallopen_fragment_hushen)
    ImageView mImgFallopenFragmentHushen;
    @BindView(R.id.rl_fallopen_fragment_hushen)
    RelativeLayout mRlFallopenFragmentHushen;
    @BindView(R.id.img_fallmore_fragment_hushen)
    ImageView mImgFallmoreFragmentHushen;
    @BindView(R.id.rv_fall_fragment_hushen)
    RecyclerView mRvFallFragmentHushen;
    @BindView(R.id.img_view_fall_fragment_hushen)
    ImageView mImgViewFallFragmentHushen;
    Unbinder unbinder;
    private boolean list,rise,fall;
    private List<Price> mPrices;
    private List<Center> mCenters;
    private Intent mIntent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hushen;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        list = true;
        rise = true;
        fall = true;
        if (!list){
            mImgListopenFragmentHushen.setImageResource(R.drawable.price_close);
            mRvListFragmentHushen.setVisibility(View.GONE);
            mImgViewListFragmentHushen.setVisibility(View.GONE);
        }
        if (!rise){
            mImgRiseopenFragmentHushen.setImageResource(R.drawable.price_close);
            mRvRiseFragmentHushen.setVisibility(View.GONE);
            mImgViewRiseFragmentHushen.setVisibility(View.GONE);
        }
        if (!fall){
            mImgFallopenFragmentHushen.setImageResource(R.drawable.price_close);
            mRvFallFragmentHushen.setVisibility(View.GONE);
            mImgViewFallFragmentHushen.setVisibility(View.GONE);
        }

        mPrices = new ArrayList<>();
        Price price1 = new Price(Color.parseColor("#FFFF0000"),"+44.00%");
        Price price2 = new Price(Color.parseColor("#FF7ED321"),"-12.00%");
        mPrices.add(price1);
        mPrices.add(price2);

        mRvListFragmentHushen.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvListFragmentHushen.setAdapter(new MyAdapter());
        mRvRiseFragmentHushen.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvRiseFragmentHushen.setAdapter(new MyAdapter());
        mRvFallFragmentHushen.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFallFragmentHushen.setAdapter(new MyAdapter());

        mCenters = new ArrayList<>();
        Center center1 = new Center("上证指数","3105.54","+2.09","+0.09%",Color.parseColor("#ff0000"));
        Center center2 = new Center("深证成指","9794.89","+64.56","+0.66%",Color.parseColor("#ff0000"));
        Center center3 = new Center("创业板","3486.51","-20.89","-0.84%",Color.parseColor("#7ED321"));
        mCenters.add(center1);
        mCenters.add(center2);
        mCenters.add(center3);

        mRvCenterFragmentHushen.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRvCenterFragmentHushen.setAdapter(new MyCenterAdapter());
    }


    @OnClick({R.id.rl_listopen_fragment_hushen, R.id.img_listmore_fragment_hushen, R.id.rl_riseopen_fragment_hushen, R.id.img_risemore_fragment_hushen, R.id.rl_fallopen_fragment_hushen, R.id.img_fallmore_fragment_hushen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_listopen_fragment_hushen:
                if (!list){
                    list = true;
                    mImgListopenFragmentHushen.setImageResource(R.drawable.price_open);
                    mRvListFragmentHushen.setVisibility(View.VISIBLE);
                    mImgViewListFragmentHushen.setVisibility(View.VISIBLE);
                }else {
                    list = false;
                    mImgListopenFragmentHushen.setImageResource(R.drawable.price_close);
                    mRvListFragmentHushen.setVisibility(View.GONE);
                    mImgViewListFragmentHushen.setVisibility(View.GONE);
                }
                break;
            case R.id.img_listmore_fragment_hushen:
                mIntent = new Intent(getActivity(), MorePlateActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_riseopen_fragment_hushen:
                if (!rise){
                    rise = true;
                    mImgRiseopenFragmentHushen.setImageResource(R.drawable.price_open);
                    mRvRiseFragmentHushen.setVisibility(View.VISIBLE);
                    mImgViewRiseFragmentHushen.setVisibility(View.VISIBLE);
                }else {
                    rise = false;
                    mImgRiseopenFragmentHushen.setImageResource(R.drawable.price_close);
                    mRvRiseFragmentHushen.setVisibility(View.GONE);
                    mImgViewRiseFragmentHushen.setVisibility(View.GONE);
                }
                break;
            case R.id.img_risemore_fragment_hushen:
                mIntent = new Intent(getActivity(), MorePlateActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_fallopen_fragment_hushen:
                if (!fall){
                    fall = true;
                    mImgFallopenFragmentHushen.setImageResource(R.drawable.price_open);
                    mRvFallFragmentHushen.setVisibility(View.VISIBLE);
                    mImgViewFallFragmentHushen.setVisibility(View.VISIBLE);
                }else {
                    fall = false;
                    mImgFallopenFragmentHushen.setImageResource(R.drawable.price_close);
                    mRvFallFragmentHushen.setVisibility(View.GONE);
                    mImgViewFallFragmentHushen.setVisibility(View.GONE);
                }
                break;
            case R.id.img_fallmore_fragment_hushen:
                mIntent = new Intent(getActivity(), MorePlateActivity.class);
                startActivity(mIntent);
                break;
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_price, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mView.setText(mPrices.get(position).getNum());
            holder.mView.setTextColor(mPrices.get(position).getColor());

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), StockActivity.class));
                }
            });

        }

        @Override
        public int getItemCount() {
            return mPrices.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;
            private TextView mView;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_list_price);
                mView = (TextView) itemView.findViewById(R.id.tv_1_list_price);

            }
        }
    }
    class Price{
        private int color;
        private String num;

        public int getColor() {
            return color;
        }

        public String getNum() {
            return num;
        }

        public Price(int color, String num) {
            this.color = color;
            this.num = num;
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
                    startActivity(new Intent(getActivity(), PlateActivity.class));
                }
            });

        }

        @Override
        public int getItemCount() {
            return mCenters.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;
            private TextView mView1,mView2,mView3,mView4;

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
    class Center{
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
}
