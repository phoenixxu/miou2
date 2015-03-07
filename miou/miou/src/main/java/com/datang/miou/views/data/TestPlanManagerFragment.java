package com.datang.miou.views.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.datang.miou.R;

/**
 * Created by dingzhongchang on 2015/3/6.
 */
public class TestPlanManagerFragment extends Fragment {


    private SearchView sv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_testplan, container, false);
        ListView listView = (ListView) root.findViewById(R.id.test_plan_listView);
        listView.setAdapter(new TestPlanListAdapter(this.getActivity(), new TestPlanInfo[]{new TestPlanInfo()}));


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
//                if (TextUtils.isEmpty(newText)) {
//                    //清楚ListView的过滤
//                    lv.clearTextFilter();
//
//                } else {
//                    //使用用户输入的内容对ListView的列表项进行过滤
//                    lv.setFilterText(newText);
//                }
                return true;
            }

            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法内执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(TestPlanManagerFragment.this.getActivity(), "您选择的是：" + query, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(true);

        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}