package com.example.administrator.stock.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.administrator.stock.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class IndexActivity extends BaseActivity {


    @BindView(R.id.ll_status_activity_invite)
    LinearLayout mLlStatusActivityInvite;
    @BindView(R.id.img_return_activity_invite)
    RelativeLayout mImgReturnActivityInvite;
    @BindView(R.id.tv_finish)
    TextView mTvFinish;
    @BindView(R.id.expandableListView)
    ExpandableListView mExpandableListView;
    private String[] groups = {"均线", "突破", "macd","kdj","成交量",
            "Boll"};
    private List<List> childs = new ArrayList<>();
    private List<String> child1,child2,child3,child4,child5,child6;
    private MyExpandableListView myExpandableListView;
    private ArrayList<String> options1Items,options2Items,options3Items ;
    private OptionsPickerView mOptionsPickerView;
    private int mInt;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        child1 = new ArrayList<>();

        child2 = new ArrayList<>();

        child3 = new ArrayList<>();

        child4 = new ArrayList<>();

        child5 = new ArrayList<>();

        child6 = new ArrayList<>();



        options1Items= new ArrayList<>();
        options2Items= new ArrayList<>();
                options3Items= new ArrayList<>();
        options1Items.add("均线金叉");
        options1Items.add("均线死叉");
        options1Items.add("一条均线在另一条均线上方");


        options2Items.add("收盘价突破新高");
        options2Items.add("收盘价突破新低");
        options2Items.add("收盘价");
        options2Items.add("收盘价");
        options2Items.add("收盘价");
        options2Items.add("收盘价");
        options2Items.add("收盘价");

        options3Items.add("收盘价");
        options3Items.add("收盘价");
        options3Items.add("收盘价");
        options3Items.add("收盘价");
        options3Items.add("收盘价");
        options3Items.add("收盘价");
        options3Items.add("收盘价");


        childs.add(child1);
        childs.add(child2);
        childs.add(child3);
        childs.add(child4);
        childs.add(child5);
        childs.add(child6);

        myExpandableListView = new MyExpandableListView();
        mExpandableListView.setAdapter(myExpandableListView);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    protected LinearLayout getStatusParams() {
        return mLlStatusActivityInvite;
    }

    @Override
    protected int color() {
        return Color.parseColor("#ff0000");
    }


    @OnClick({R.id.img_return_activity_invite, R.id.tv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_return_activity_invite:
                finish();
                break;
            case R.id.tv_finish:
                Intent intent = new Intent();
                intent.putExtra("result",setMessage());
                setResult(1001,intent);
                finish();
                break;
        }
    }
    class MyExpandableListView extends BaseExpandableListAdapter {

        //返回一级列表的个数
        @Override
        public int getGroupCount() {
            return groups.length;
        }

        //返回每个二级列表的个数
        @Override
        public int getChildrenCount(int groupPosition) { //参数groupPosition表示第几个一级列表
            Log.d("smyhvae", "-->" + groupPosition);
            return childs.get(groupPosition).size();
        }

        //返回一级列表的单个item（返回的是对象）
        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition].length();
        }

        //返回二级列表中的单个item（返回的是对象）
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs.get(groupPosition).get(childPosition);  //不要误写成groups[groupPosition][childPosition]
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //每个item的id是否是固定？一般为true
        @Override
        public boolean hasStableIds() {
            return true;
        }

        //【重要】填充一级列表
        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_group, null);
            }
            TextView tv_group = (TextView) convertView.findViewById(R.id.tv_group);
            tv_group.setText(groups[groupPosition]);
            TextView tv_add = (TextView)convertView.findViewById(R.id.tv_add);
            tv_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInt=groupPosition;
                    showPickerView();



                }
            });
            return convertView;
        }

        //【重要】填充二级列表
        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_child, null);
            }

            TextView iv_child = (TextView) convertView.findViewById(R.id.iv_child);
            TextView tv_child = (TextView) convertView.findViewById(R.id.tv_child);

            //iv_child.setImageResource(resId);
            tv_child.setText((String)childs.get(groupPosition).get(childPosition));
            iv_child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    childs.get(groupPosition).remove(childPosition);
                    myExpandableListView.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        //二级列表中的item是否能够被选中？可以改为true
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
    private void showPickerView(){
        mOptionsPickerView = new  OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3 ,View v) {
                //返回的分别是三个级别的选中位置
                String s = options1Items.get(options1);
                childs.get(mInt).add(s);
                myExpandableListView.notifyDataSetChanged();
            }
        }).build();
        if (mInt==0){
            options1Items.clear();
            options1Items.add("均线金叉");
            options1Items.add("均线死叉");
            options1Items.add("一条均线在另一条均线上方");
        }else if (mInt==1){
            options1Items.clear();
            options1Items.add("收盘价突破新高");
            options1Items.add("收盘价突破新低");

        }else if (mInt==2){
            options1Items.clear();
            options1Items.add("均线金叉");
            options1Items.add("均线死叉");

        }else if (mInt==3){
            options1Items.clear();
            options1Items.add("均线金叉");
            options1Items.add("均线死叉");
        }else if (mInt==4){
            options1Items.clear();
            options1Items.add("成交量突破新高");
            options1Items.add("成交量跌破新低");
            options1Items.add("成交量放量");
            options1Items.add("成交量缩量");
        }else if (mInt == 5){
            options1Items.clear();
            options1Items.add("收盘价突破上轨");
            options1Items.add("收盘价突破轨");
        }
        mOptionsPickerView.setPicker(options1Items);
        mOptionsPickerView.show();
    }
    private String setMessage(){
        String s = "";
        if (child1.size()!=0){
            s = s+ groups[0]+child1.toString();
        }
        if (child2.size()!=0){
            s = s+groups[1]+child2.toString();
        }
        if (child3.size()!=0){
            s = s+groups[2]+child3.toString();
        }
        if (child4.size()!=0){
            s = s+groups[3]+child4.toString();
        }
        if (child5.size()!=0){
            s = s+groups[4]+child5.toString();
        }
        if (child6.size()!=0){
            s = s+groups[5]+child6.toString();
        }
        return s;
    }
}
