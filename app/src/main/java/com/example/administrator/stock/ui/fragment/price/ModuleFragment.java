package com.example.administrator.stock.ui.fragment.price;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
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

public class ModuleFragment extends BaseFragment {
    @BindView(R.id.rv_center_fragment_module)
    RecyclerView mRvCenterFragmentModule;
    @BindView(R.id.img_industryopen_fragment_module)
    ImageView mImgIndustryopenFragmentModule;
    @BindView(R.id.rl_industryopen_fragment_module)
    RelativeLayout mRlIndustryopenFragmentModule;
    @BindView(R.id.img_industrymore_fragment_module)
    ImageView mImgIndustrymoreFragmentModule;
    @BindView(R.id.rl_industry_fragment_module)
    RelativeLayout mRlIndustryFragmentModule;
    @BindView(R.id.rv_industry_fragment_module)
    RecyclerView mRvIndustryFragmentModule;
    @BindView(R.id.img_view_industry_fragment_module)
    ImageView mImgViewIndustryFragmentModule;
    @BindView(R.id.img_ideaopen_fragment_module)
    ImageView mImgIdeaopenFragmentModule;
    @BindView(R.id.rl_ideaopen_fragment_module)
    RelativeLayout mRlIdeaopenFragmentModule;
    @BindView(R.id.img_ideamore_fragment_module)
    ImageView mImgIdeamoreFragmentModule;
    @BindView(R.id.rv_idea_fragment_module)
    RecyclerView mRvIdeaFragmentModule;
    @BindView(R.id.img_view_idea_fragment_module)
    ImageView mImgViewIdeaFragmentModule;
    @BindView(R.id.img_riseopen_fragment_module)
    ImageView mImgRiseopenFragmentModule;
    @BindView(R.id.rl_riseopen_fragment_module)
    RelativeLayout mRlRiseopenFragmentModule;
    @BindView(R.id.img_risemore_fragment_module)
    ImageView mImgRisemoreFragmentModule;
    @BindView(R.id.rv_rise_fragment_module)
    RecyclerView mRvRiseFragmentModule;
    @BindView(R.id.img_view_rise_fragment_module)
    ImageView mImgViewRiseFragmentModule;
    Unbinder unbinder;
    private List<Center> mCenters;
    private boolean industry,idea,rise;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_module;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mCenters = new ArrayList<>();
        Center center1 = new Center("上证指数","3105.54","+2.09","+0.09%", Color.parseColor("#ff0000"));
        Center center2 = new Center("深证成指","9794.89","+64.56","+0.66%",Color.parseColor("#ff0000"));
        Center center3 = new Center("创业板","3486.51","-20.89","-0.84%",Color.parseColor("#7ED321"));
        mCenters.add(center1);
        mCenters.add(center2);
        mCenters.add(center3);
        mRvCenterFragmentModule.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRvCenterFragmentModule.setAdapter(new MyCenterAdapter());
        mRvIndustryFragmentModule.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRvIndustryFragmentModule.setAdapter(new MyAdapter());
        mRvIdeaFragmentModule.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRvIdeaFragmentModule.setAdapter(new MyAdapter());
        mRvRiseFragmentModule.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRvRiseFragmentModule.setAdapter(new MyAdapter());

        industry = true;
        idea = true;
        rise = true;
        if (!industry){
            mImgIndustryopenFragmentModule.setImageResource(R.drawable.price_close);
            mRvIndustryFragmentModule.setVisibility(View.GONE);
            mImgViewIndustryFragmentModule.setVisibility(View.GONE);
        }
        if (!idea){
            mImgIdeaopenFragmentModule.setImageResource(R.drawable.price_close);
            mRvIdeaFragmentModule.setVisibility(View.GONE);
            mImgViewIdeaFragmentModule.setVisibility(View.GONE);
        }
        if (!rise){
            mImgRiseopenFragmentModule.setImageResource(R.drawable.price_close);
            mRvRiseFragmentModule.setVisibility(View.GONE);
            mImgViewRiseFragmentModule.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.rl_industryopen_fragment_module, R.id.img_industrymore_fragment_module, R.id.rl_ideaopen_fragment_module, R.id.img_ideamore_fragment_module, R.id.rl_riseopen_fragment_module, R.id.img_risemore_fragment_module})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_industryopen_fragment_module:
                if (!industry){
                    industry = true;
                    mImgIndustryopenFragmentModule.setImageResource(R.drawable.price_open);
                    mRvIndustryFragmentModule.setVisibility(View.VISIBLE);
                    mImgViewIndustryFragmentModule.setVisibility(View.VISIBLE);
                }else {
                    industry = false;
                    mImgIndustryopenFragmentModule.setImageResource(R.drawable.price_close);
                    mRvIndustryFragmentModule.setVisibility(View.GONE);
                    mImgViewIndustryFragmentModule.setVisibility(View.GONE);
                }
                break;
            case R.id.img_industrymore_fragment_module:
                break;
            case R.id.rl_ideaopen_fragment_module:
                if (!idea){
                    idea = true;
                    mImgIdeaopenFragmentModule.setImageResource(R.drawable.price_open);
                    mRvIdeaFragmentModule.setVisibility(View.VISIBLE);
                    mImgViewIdeaFragmentModule.setVisibility(View.VISIBLE);
                }else {
                    idea = false;
                    mImgIdeaopenFragmentModule.setImageResource(R.drawable.price_close);
                    mRvIdeaFragmentModule.setVisibility(View.GONE);
                    mImgViewIdeaFragmentModule.setVisibility(View.GONE);
                }
                break;
            case R.id.img_ideamore_fragment_module:
                break;
            case R.id.rl_riseopen_fragment_module:
                if (!rise){
                    rise = true;
                    mImgRiseopenFragmentModule.setImageResource(R.drawable.price_open);
                    mRvRiseFragmentModule.setVisibility(View.VISIBLE);
                    mImgViewRiseFragmentModule.setVisibility(View.VISIBLE);
                }else {
                    rise = false;
                    mImgRiseopenFragmentModule.setImageResource(R.drawable.price_close);
                    mRvRiseFragmentModule.setVisibility(View.GONE);
                    mImgViewRiseFragmentModule.setVisibility(View.GONE);
                }
                break;
            case R.id.img_risemore_fragment_module:
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
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_module, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {


            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;


            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_list_module);


            }
        }
    }
}
