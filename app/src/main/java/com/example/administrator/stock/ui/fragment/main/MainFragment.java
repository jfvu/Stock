package com.example.administrator.stock.ui.fragment.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.fragment.BaseFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.img_head_fragment_main)
    ImageView mImgHeadFragmentMain;
    @BindView(R.id.vp_fragment_main)
    ViewPager mVpFragmentMain;
    @BindView(R.id.rl_wind)
    RelativeLayout mRlWind;
    @BindView(R.id.rl_tactics)
    RelativeLayout mRlTactics;
    @BindView(R.id.rl_skill)
    RelativeLayout mRlSkill;
    @BindView(R.id.rl_simulate)
    RelativeLayout mRlSimulate;
    @BindView(R.id.rl_new)
    RelativeLayout mRlNew;
    @BindView(R.id.rl_match)
    RelativeLayout mRlMatch;
    @BindView(R.id.rv_gold_fragment_main)
    RecyclerView mRvGoldFragmentMain;
    @BindView(R.id.rv_invest_fragment_main)
    RecyclerView mRvInvestFragmentMain;
    Unbinder unbinder;
    @BindView(R.id.lin_points)
    LinearLayout mLinPoints;
    Unbinder unbinder1;
    private int[] images = new int[]{R.drawable.main_banner, R.drawable.main_banner, R.drawable.main_banner};  //模拟存放要展示的图片
    private List<ImageView> imageViews;
    private Handler handler;
    private List<TextView> txtPoints;
    private SlidingMenu menu;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        initImageViews();
        initVp();
        initCircle();
        handler = new Handler();
        handler.postDelayed(new TimerRunnable(), 3000);
        mRvGoldFragmentMain.setLayoutManager( new GridLayoutManager(getActivity(),3));
        mRvGoldFragmentMain.setAdapter(new MyAdapter());
        mRvInvestFragmentMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvInvestFragmentMain.setAdapter(new MyAdapter2());

        menu = new SlidingMenu(getActivity());
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffset(263);
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.4f);
        menu.attachToActivity(getActivity(),SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.slidingmenu);

    }


    @OnClick({R.id.img_head_fragment_main, R.id.rl_wind, R.id.rl_tactics, R.id.rl_skill, R.id.rl_simulate, R.id.rl_new, R.id.rl_match})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_head_fragment_main:
                menu.toggle();
                break;
            case R.id.rl_wind:
                break;
            case R.id.rl_tactics:
                break;
            case R.id.rl_skill:
                break;
            case R.id.rl_simulate:
                break;
            case R.id.rl_new:
                break;
            case R.id.rl_match:
                break;
        }
    }

    /**
     * 初始化图片资源
     */
    private void initImageViews() {
        imageViews = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[i]);
            imageViews.add(imageView);
        }
    }

    private void initVp() {


        mVpFragmentMain.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //                return imageViews.size(); 修改如下
                return 10000;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //                container.removeView(imageViews.get(position%imageViews.size())); 删除此句
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //                container.addView(imageViews.get(position));
                //                return imageViews.get(position);  修改如下
                try {
                    container.addView(imageViews.get(position%imageViews.size()));
                }catch (Exception e){

                }
                return imageViews.get(position%imageViews.size());
            }
        });

        mVpFragmentMain.setCurrentItem(imageViews.size()*1000);

        mVpFragmentMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changePoints((position)%imageViews.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    class TimerRunnable implements Runnable {

        @Override
        public void run() {
            int curItem;
            if (mVpFragmentMain!=null){
            curItem = mVpFragmentMain.getCurrentItem();}
            else {
                curItem = 0;
            }
            if (mVpFragmentMain!= null){
            mVpFragmentMain.setCurrentItem(curItem + 1);}
            else {
                //mVpFragmentMain.setCurrentItem(0);
            }
            if (handler != null) {
                handler.postDelayed(this, 3000);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler = null; //此处在Activity退出时及时 回收
    }

    /**
     * 初始化小圆点
     */
    private void initCircle() {
        txtPoints = new ArrayList<>();
        int d = 20;
        int m = 7;
        for (int i = 0; i < imageViews.size(); i++) {
            TextView txt = new TextView(getActivity());
            if (i == 0) {
                txt.setBackgroundResource(R.drawable.shape_main_point_select);
            } else {
                txt.setBackgroundResource(R.drawable.shape_main_point_normal);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(d, d);

            params.setMargins(m, m, m, m);
            txt.setLayoutParams(params);
            txtPoints.add(txt);
            mLinPoints.addView(txt);
        }
    }
    public void changePoints(int pos) {
        if (txtPoints != null) {
            for (int i = 0; i < txtPoints.size(); i++) {
                if (pos == i) {
                    txtPoints.get(i).setBackgroundResource(R.drawable.shape_main_point_select);
                } else {
                    txtPoints.get(i).setBackgroundResource(R.drawable.shape_main_point_normal);
                }
            }
        }
    }
    class MyAdapter2 extends RecyclerView.Adapter<MainFragment.MyAdapter2.ViewHolder> {

        @Override
        public MainFragment.MyAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_invest_main, parent, false);
            AutoUtils.autoSize(view);
            return new MainFragment.MyAdapter2.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MainFragment.MyAdapter2.ViewHolder holder, final int position) {

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_item_rv_invest);

            }
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MainFragment.MyAdapter.ViewHolder> {

        @Override
        public MainFragment.MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rv_gold_main, parent, false);
            AutoUtils.autoSize(view);
            return new MainFragment.MyAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MainFragment.MyAdapter.ViewHolder holder, final int position) {

            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.ll_item_rv_gold);

            }
        }
    }
}
