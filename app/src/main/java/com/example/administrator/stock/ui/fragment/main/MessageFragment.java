package com.example.administrator.stock.ui.fragment.main;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stock.R;
import com.example.administrator.stock.ui.activity.MessageActivity;
import com.example.administrator.stock.ui.activity.MessageSetActivity;
import com.example.administrator.stock.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public class MessageFragment extends BaseFragment {
    @BindView(R.id.tv_set_fragment_message)
    TextView mTvSetFragmentMessage;
    @BindView(R.id.rl_1_fragment_message)
    RelativeLayout mRl1FragmentMessage;
    @BindView(R.id.rl_2_fragment_message)
    RelativeLayout mRl2FragmentMessage;
    @BindView(R.id.rl_3_fragment_message)
    RelativeLayout mRl3FragmentMessage;
    @BindView(R.id.rl_4_fragment_message)
    RelativeLayout mRl4FragmentMessage;
    @BindView(R.id.rl_5_fragment_message)
    RelativeLayout mRl5FragmentMessage;
    @BindView(R.id.rl_6_fragment_message)
    RelativeLayout mRl6FragmentMessage;
    @BindView(R.id.rl_system_fragment_message)
    RelativeLayout mRlSystemFragmentMessage;
    @BindView(R.id.rl_room_fragment_message)
    RelativeLayout mRlRoomFragmentMessage;
    Unbinder unbinder;
    private Intent mIntent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }



    @OnClick({R.id.tv_set_fragment_message, R.id.rl_1_fragment_message, R.id.rl_2_fragment_message, R.id.rl_3_fragment_message, R.id.rl_4_fragment_message, R.id.rl_5_fragment_message, R.id.rl_6_fragment_message, R.id.rl_system_fragment_message, R.id.rl_room_fragment_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_set_fragment_message:
                mIntent = new Intent(getActivity(), MessageSetActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_1_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_2_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_3_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_4_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_5_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_6_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                startActivity(mIntent);
                break;
            case R.id.rl_system_fragment_message:
                mIntent = new Intent(getActivity(), MessageActivity.class);
                mIntent.putExtra("MessageActivity","system");
                startActivity(mIntent);
                break;
            case R.id.rl_room_fragment_message:
                break;
        }
    }
}
