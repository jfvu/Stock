package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.AiPop;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.kareluo.ui.OptionMenu;
import me.kareluo.ui.OptionMenuView;
import me.kareluo.ui.PopupMenuView;
import me.kareluo.ui.PopupView;

import static com.example.administrator.stock.ui.activity.EnterActivity.RESULT_CODE;

public class AiActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_ai)
    LinearLayout mLlStatusActivityAi;
    @BindView(R.id.img_return_activity_ai)
    RelativeLayout mImgReturnActivityAi;
    @BindView(R.id.tv_creat_activity_ai)
    TextView mTvCreatActivityAi;
    @BindView(R.id.rb_all_activity_ai)
    RadioButton mRbAllActivityAi;
    @BindView(R.id.rb_release_activity_ai)
    RadioButton mRbReleaseActivityAi;
    @BindView(R.id.rb_buy_activity_ai)
    RadioButton mRbBuyActivityAi;
    @BindView(R.id.rb_creat_activity_ai)
    RadioButton mRbCreatActivityAi;
    @BindView(R.id.rv_activity_ai)
    RecyclerView mRvActivityAi;
    @BindView(R.id.rb_collect_activity_ai)
    RadioButton mRbCollectActivityAi;
    //private List<String> popupMenuItemList = new ArrayList<>();
    private PopupMenuView mMenuView;
    private final static int REQUEST_CODE = 1;
    private AiPop mAiPop;
    private WindowManager.LayoutParams lp;
    private Window window;
    private ArrayList<String> mList;
    private boolean flag = false;

    @Override
    protected void initData() {
        mRbAllActivityAi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    flag = true;
                }
            }
        });
        mRbAllActivityAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRbAllActivityAi.isChecked() && flag) {
                    openPop();
                }
            }
        });
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        mList.add("年化收益率");
        mList.add("总收益");
        mList.add("90天收益");
        mList.add("30天收益");
        mList.add("交易胜率");
        mList.add("最大回撤率");
        mRbAllActivityAi.setChecked(true);
        flag = true;
        mRvActivityAi.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityAi.setAdapter(new MyAdapter());

        mMenuView = new PopupMenuView(AiActivity.this, R.menu.menu_pop, new MenuBuilder(this));
        mMenuView.setOrientation(LinearLayout.HORIZONTAL);
        mMenuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
            @Override
            public boolean onOptionMenuClick(int position, OptionMenu menu) {
                Toast.makeText(AiActivity.this, "" + menu.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mRbAllActivityAi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_ai;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAi;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_ai, R.id.tv_creat_activity_ai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_ai:
                finish();
                break;
            case R.id.tv_creat_activity_ai:
                Intent intent = new Intent();
                intent.setClass(this, AddTacticsActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(AiActivity.this).inflate(R.layout.item_rv_ai, parent, false);
            AutoUtils.autoSize(view);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    mMenuView.setMenuItems(Arrays.asList(
                            new OptionMenu("置顶"), new OptionMenu("置底"),
                            new OptionMenu("修改"), new OptionMenu("删除")));
                    mMenuView.show(holder.mView);
                    mMenuView.setSites(PopupView.SITE_RIGHT);
                    return true;
                }
            });
            holder.mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AiActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            });


        }

        @Override
        public int getItemCount() {
            return 8;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private View mView;
            private RelativeLayout mLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                mLayout = (RelativeLayout) itemView.findViewById(R.id.rl_all_item_ai);
                mView = (View) itemView.findViewById(R.id.v_location);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                mRbReleaseActivityAi.setChecked(true);

            }
        }
    }

    private void openPop() {
        mAiPop = new AiPop(this, onClickListener, mList);
        window = this.getWindow();
        lp = this.getWindow()
                .getAttributes();
        lp.alpha = 0.4f;
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        this.getWindow().setAttributes(lp);
        mAiPop.setTouchable(true);
        mAiPop.setFocusable(true);
        mAiPop.setBackgroundDrawable(new BitmapDrawable());
        mAiPop.setOutsideTouchable(true);


        mAiPop.showAsDropDown(this.findViewById(R.id.rb_all_activity_ai));
        mAiPop.setOnDismissListener(new PopupWindow.OnDismissListener() {

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
            switch (v.getId()) {
                case R.id.ll_item_rv_pop:
                    mAiPop.dismiss();
                    mRbAllActivityAi.setText(mList.get((Integer) v.getTag()));

            }
        }
    };
}
