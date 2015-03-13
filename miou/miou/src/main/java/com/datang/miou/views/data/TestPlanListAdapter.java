package com.datang.miou.views.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.datang.miou.R;

/**
 * Created by dingzhongchang on 2015/3/6.
 */
public class TestPlanListAdapter extends ArrayAdapter<TestPlanInfo> {

    private final Context mContext;
    private final TestPlanInfo[] mItems;
    private final LayoutInflater mLayoutInflater;

    public TestPlanListAdapter(Context context, TestPlanInfo[] objects) {
        super(context, R.layout.data_list_item, objects);
        this.mContext = context;
        this.mItems = objects;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = mLayoutInflater.inflate(R.layout.data_list_item, parent, false);
        }

        TestPlanInfo info = mItems[position];

        if (info != null) {
//            ((TextView) v.findViewById(R.id.tv_creator_id)).setText(info.creatorId);

        }
        return v;
    }
}
