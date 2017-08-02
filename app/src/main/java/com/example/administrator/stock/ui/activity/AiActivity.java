package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.stock.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import me.kareluo.ui.OptionMenu;
import me.kareluo.ui.OptionMenuView;
import me.kareluo.ui.PopupMenuView;
import me.kareluo.ui.PopupView;

public class AiActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_ai)
    LinearLayout mLlStatusActivityAi;
    @BindView(R.id.img_return_activity_ai)
    ImageView mImgReturnActivityAi;
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
    //private List<String> popupMenuItemList = new ArrayList<>();
    private PopupMenuView mMenuView;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRbAllActivityAi.setChecked(true);
        mRvActivityAi.setLayoutManager(new LinearLayoutManager(this));
        mRvActivityAi.setAdapter(new MyAdapter());

        mMenuView = new PopupMenuView(AiActivity.this,R.menu.menu_pop,new MenuBuilder(this));
        mMenuView.setOrientation(LinearLayout.HORIZONTAL);
        mMenuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
            @Override
            public boolean onOptionMenuClick(int position, OptionMenu menu) {
                Toast.makeText(AiActivity.this, ""+menu.getTitle(), Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(AiActivity.this,AddTacticsActivity.class));
                break;
        }
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
                    Toast.makeText(AiActivity.this, ""+position, Toast.LENGTH_SHORT).show();
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

}
