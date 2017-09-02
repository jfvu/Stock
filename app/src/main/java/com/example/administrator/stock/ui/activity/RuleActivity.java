package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.view.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RuleActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_rule)
    LinearLayout mLlStatusActivityRule;
    @BindView(R.id.img_return_activity_rule)
    RelativeLayout mImgReturnActivityRule;
    @BindView(R.id.tv_title_center_activity_rule)
    TextView mTvTitleCenterActivityRule;
    @BindView(R.id.rl_index_activity_rule)
    RelativeLayout mRlIndexActivityRule;
    @BindView(R.id.rl_base_activity_rule)
    RelativeLayout mRlBaseActivityRule;
    @BindView(R.id.rl_bulid_activity_rule)
    RelativeLayout mRlBulidActivityRule;
    @BindView(R.id.img_open1_activity_rule)
    ImageView mImgOpen1ActivityRule;
    @BindView(R.id.btn_change_activity_rule)
    Button mBtnChangeActivityRule;
    @BindView(R.id.img_open2_activity_rule)
    ImageView mImgOpen2ActivityRule;
    @BindView(R.id.tv_show)
    TextView mTvShow;
    @BindView(R.id.rl_rank)
    RelativeLayout mRlRank;
    @BindView(R.id.ll_number)
    RelativeLayout mLlNumber;
    @BindView(R.id.tv_show1)
    TextView mTvShow1;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.tv_3)
    TextView mTv3;
    private Intent mIntent;
    private SpinerPopWindow<String> mSpinerPopWindow, mSpinerPopWindow1;

    private List<String> list, list1;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        list = new ArrayList<>();
        list.add("市净率");
        list.add("总市值");
        list.add("流通市值");
        list.add("总股本");
        list.add("流通股本");
        list.add("股票价格");
        list.add("市盈率");
        list.add("涨幅(从低到高)");
        list.add("涨幅(从高到低)");
        list.add("跌幅(从低到高)");
        list.add("跌幅(从高到低)");
        list1 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list1.add(String.valueOf(i + 1));
        }
        mIntent = getIntent();
        String title = mIntent.getStringExtra("RuleActivity");
        mTvTitleCenterActivityRule.setText(title);
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list, itemClickListener);
        mSpinerPopWindow.setOnDismissListener(dismissListener);
        mSpinerPopWindow1 = new SpinerPopWindow<String>(this, list1, itemClickListener1);
        mSpinerPopWindow1.setOnDismissListener(dismissListener);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rule;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityRule;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_rule, R.id.rl_index_activity_rule, R.id.rl_base_activity_rule, R.id.rl_bulid_activity_rule, R.id.rl_rank, R.id.btn_change_activity_rule, R.id.ll_number})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_rule:
                finish();
                break;
            case R.id.rl_index_activity_rule:
                mIntent = new Intent(RuleActivity.this, IndexActivity.class);
                startActivityForResult(mIntent, 1000);
                break;
            case R.id.rl_base_activity_rule:
                mIntent = new Intent(RuleActivity.this, FundamentalsActivity.class);
                startActivityForResult(mIntent, 1000);
                break;
            case R.id.rl_bulid_activity_rule:
                break;
            case R.id.rl_rank:
                mSpinerPopWindow.setWidth(mRlRank.getWidth());
                mSpinerPopWindow.showAsDropDown(mRlRank);
                //setTextImage(R.drawable.icon_up);

                break;
            case R.id.btn_change_activity_rule:
                break;
            case R.id.ll_number:
                mSpinerPopWindow1.setWidth(mLlNumber.getWidth());
                mSpinerPopWindow1.showAsDropDown(mLlNumber);
                break;
        }
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow.dismiss();
            mTvShow.setText(list.get(position));
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener1 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow1.dismiss();
            mTvShow1.setText(list1.get(position));
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };


    private PopupWindow.OnDismissListener dismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            //setTextImage(R.drawable.icon_down);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 1001) {
            mTv1.setText(data.getStringExtra("result"));
        } else if (requestCode == 1000 && resultCode == 1002) {
            mTv3.setText(data.getStringExtra("result"));
        }
    }



}
