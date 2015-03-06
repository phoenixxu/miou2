package com.datang.miou.views.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.datang.miou.R;

/**
 * Created by dingzhongchang on 2015/3/6.
 */
public class TestPlanListAdapter extends ArrayAdapter<TestPlanInfo> {

    private final Context mContext;
    private final TestPlanInfo[] mItems;

    public TestPlanListAdapter(Context context, int textViewResourceId, TestPlanInfo[] objects) {
        super(context, textViewResourceId, objects);
        this.mContext = context;
        this.mItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {

            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = vi.inflate(R.layout.test_plan_list_item, null);

        }

        TestPlanInfo info = mItems[position];

        if (info != null) {

            TextView content1 = (TextView) v.findViewById(R.id.list_content1);

            TextView content2 = (TextView) v.findViewById(R.id.list_content2);

            if (content1 != null) {

                content1.setText(user.classID);
            }
            if (content2 != null) {

                content2.setText(user.state);
            }
        }
        return v;
    }
}
