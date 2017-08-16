package com.example.administrator.stock.ui.activity;

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

public class StopActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_stop)
    LinearLayout mLlStatusActivityStop;
    @BindView(R.id.img_return_activity_stop)
    RelativeLayout mImgReturnActivityStop;
    @BindView(R.id.img_open1_activity_stop)
    ImageView mImgOpen1ActivityStop;
    @BindView(R.id.btn_change1_activity_stop)
    Button mBtnChange1ActivityStop;
    @BindView(R.id.img_open2_activity_stop)
    ImageView mImgOpen2ActivityStop;
    @BindView(R.id.btn_change2_activity_stop)
    Button mBtnChange2ActivityStop;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.rl_1)
    RelativeLayout mRl1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.rl_2)
    RelativeLayout mRl2;
    private SpinerPopWindow mSpinerPopWindow,mSpinerPopWindow1;
    private List<String> list;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i+1));
        }
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list, itemClickListener);
        mSpinerPopWindow.setOnDismissListener(dismissListener);
        mSpinerPopWindow1 = new SpinerPopWindow<String>(this,list,itemClickListener1);
        mSpinerPopWindow1.setOnDismissListener(dismissListener);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityStop;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_stop, R.id.rl_1, R.id.btn_change1_activity_stop, R.id.rl_2, R.id.btn_change2_activity_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_stop:
                finish();
                break;
            case R.id.rl_1:
                mSpinerPopWindow.setWidth(mRl1.getWidth());
                mSpinerPopWindow.showAsDropDown(mRl1);
                break;
            case R.id.btn_change1_activity_stop:
                break;
            case R.id.rl_2:
                mSpinerPopWindow1.setWidth(mRl2.getWidth());
                mSpinerPopWindow1.showAsDropDown(mRl2);
                break;
            case R.id.btn_change2_activity_stop:
                break;
        }
    }

    private PopupWindow.OnDismissListener dismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            //setTextImage(R.drawable.icon_down);
        }
    };
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow.dismiss();

            mTv1.setText("股价相对于成本上涨超过"+list.get(position)+"%");
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener1 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow1.dismiss();

            mTv2.setText("股价相对于成本下跌超过"+list.get(position)+"%");
            //Toast.makeText(this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };
}
