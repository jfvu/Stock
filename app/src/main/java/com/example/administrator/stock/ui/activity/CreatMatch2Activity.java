package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

public class CreatMatch2Activity extends BaseActivity {

    @BindView(R.id.ll_status_activity_creatmatch2)
    LinearLayout mLlStatusActivityCreatmatch2;
    @BindView(R.id.img_return_activity_creatmatch2)
    RelativeLayout mImgReturnActivityCreatmatch2;
    @BindView(R.id.rl_way_activity_creatmatch2)
    RelativeLayout mRlWayActivityCreatmatch2;
    @BindView(R.id.rl_explain_activity_creatmatch2)
    RelativeLayout mRlExplainActivityCreatmatch2;
    @BindView(R.id.btn_submit_activity_creatmatvh2)
    Button mBtnSubmitActivityCreatmatvh2;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_creat_match2;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityCreatmatch2;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_creatmatch2, R.id.rl_way_activity_creatmatch2, R.id.rl_explain_activity_creatmatch2, R.id.btn_submit_activity_creatmatvh2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_creatmatch2:
                finish();
                break;
            case R.id.rl_way_activity_creatmatch2:
                break;
            case R.id.rl_explain_activity_creatmatch2:
                startActivity(new Intent(this,MatchExplain2Activity.class));
                break;
            case R.id.btn_submit_activity_creatmatvh2:
                break;
        }
    }
}
