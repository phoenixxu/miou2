package com.datang.miou.views.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.datang.miou.R;

/**
 * Created by dingzhongchang on 2015/3/6.
 */
public class TestPlanManagerFragment extends Fragment {


    private static final int REQUEST_NEWPLAN = 1000;
    public static final String RESULT_NEWPLAN = "NEW_PALN";
    private SearchView sv;
    private TestPlanListAdapter testPlanListAdapter;
    private FragmentActivity mContext;
    private ListView planListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_testplan, container, false);
        planListView = (ListView) root.findViewById(R.id.test_plan_listView);
        testPlanListAdapter = new TestPlanListAdapter(this.getActivity(), new TestPlanInfo[]{});
        planListView.setAdapter(testPlanListAdapter);
        planListView.setTextFilterEnabled(true);


//        lv = (ListView) root.findViewById(R.id.lv);
//        String[] strings = this.getResources().getStringArray(R.array.testtype);
//        lv.setAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strings));
//        lv.setTextFilterEnabled(true);

        sv = (SearchView) root.findViewById(R.id.sv);
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(true);
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //用户输入字符时激发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    //清楚ListView的过滤
                    planListView.clearTextFilter();

                } else {
                    //使用用户输入的内容对ListView的列表项进行过滤
                    planListView.setFilterText(newText);
                }
                return false;
            }

            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法内执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(mContext, "您选择的是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(true);

        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");

        initOnClick(root);

        return root;
    }

    private void initOnClick(final View root) {
        root.findViewById(R.id.bt_plan_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 新增测试序列
                Intent intent = new Intent(mContext, NewPlanListActivity.class);
                TestPlanManagerFragment.this.startActivityForResult(intent, REQUEST_NEWPLAN);

            }
        });
        root.findViewById(R.id.bt_plan_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 编辑测试任务
                TestPlanInfo info = testPlanListAdapter.getSelected();
            }
        });
        root.findViewById(R.id.bt_plan_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 测试序列下载
            }
        });
        root.findViewById(R.id.bt_plan_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 全选
                testPlanListAdapter.selectAll(true);
            }
        });

        root.findViewById(R.id.bt_plan_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO  删除测试序列
                testPlanListAdapter.del();
                scrollToBottom();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_NEWPLAN) {
                String planName = data.getExtras().getString(RESULT_NEWPLAN);
                //TODO 返回新建的测试序列
                Toast.makeText(mContext, planName, Toast.LENGTH_SHORT).show();
                testPlanListAdapter.add(new TestPlanInfo(planName, "admin"));
                scrollToBottom();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void scrollToBottom() {
        planListView.setSelection(testPlanListAdapter.getCount() - 1);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}