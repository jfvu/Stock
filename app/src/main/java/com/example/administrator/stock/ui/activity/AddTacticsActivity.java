package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.stock.R;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.administrator.stock.ui.activity.EnterActivity.RESULT_CODE;

public class AddTacticsActivity extends BaseActivity {

    @BindView(R.id.ll_status_activity_addtactics)
    LinearLayout mLlStatusActivityAddtactics;
    @BindView(R.id.img_return_activity_addtactics)
    RelativeLayout mImgReturnActivityAddtactics;
    @BindView(R.id.rl_name_activity_tactics)
    RelativeLayout mRlNameActivityTactics;
    @BindView(R.id.rl_appoint_activity_tactics)
    RelativeLayout mRlAppointActivityTactics;
    @BindView(R.id.rl_buy_activity_tactics)
    RelativeLayout mRlBuyActivityTactics;
    @BindView(R.id.rl_sell_activity_tactics)
    RelativeLayout mRlSellActivityTactics;
    @BindView(R.id.rl_stop_activity_tactics)
    RelativeLayout mRlStopActivityTactics;
    @BindView(R.id.rl_lucation_activity_tactics)
    RelativeLayout mRlLucationActivityTactics;
    @BindView(R.id.rl_price_activity_tactics)
    RelativeLayout mRlPriceActivityTactics;
    @BindView(R.id.btn_test_activity_tactics)
    Button mBtnTestActivityTactics;
    private Intent mIntent;
    private final static int REQUEST_CODE=1;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_tactics;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityAddtactics;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }



    @OnClick({R.id.img_return_activity_addtactics, R.id.rl_name_activity_tactics, R.id.rl_appoint_activity_tactics, R.id.rl_buy_activity_tactics, R.id.rl_sell_activity_tactics, R.id.rl_stop_activity_tactics, R.id.rl_lucation_activity_tactics, R.id.rl_price_activity_tactics, R.id.btn_test_activity_tactics})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_addtactics:
                finish();
                break;
            case R.id.rl_name_activity_tactics:
                break;
            case R.id.rl_appoint_activity_tactics:
                mIntent = new Intent(this,AppointActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_buy_activity_tactics:
                mIntent = new Intent(this,RuleActivity.class);
                mIntent.putExtra("RuleActivity","买入规则");
                startActivity(mIntent);
                break;
            case R.id.rl_sell_activity_tactics:
                mIntent = new Intent(this,RuleActivity.class);
                mIntent.putExtra("RuleActivity","卖出规则");
                startActivity(mIntent);
                break;
            case R.id.rl_stop_activity_tactics:
                mIntent = new Intent(this,StopActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_lucation_activity_tactics:
                mIntent = new Intent(this,ManageSiteActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_price_activity_tactics:
                break;
            case R.id.btn_test_activity_tactics:
                Intent intent=new Intent();
                intent.setClass(this, TacticsTestActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE)
        {
            if (resultCode== TacticsTestActivity.RESULT_CODE)
            {
                Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                setResult(RESULT_CODE, intent);
                this.finish();

            }
        }
    }
}
