package com.example.asadrao.expandablelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExListAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> langs;
    Map<String,List<String>> topics;

    public MyExListAdapter(Context context, List<String> langs, Map<String, List<String>> topics) {
        this.context = context;
        this.langs = langs;
        this.topics = topics;
    }

    @Override

    public int getGroupCount() {
        return langs.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return topics.get(langs.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return langs.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return topics.get(langs.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String langs = (String) getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_parent,null);
        }
        TextView txtParent = (TextView)convertView.findViewById(R.id.txtParent);
        txtParent.setText(langs);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String topics = (String) getChild(groupPosition,childPosition);
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_child, null);
        }
        TextView txtChild = (TextView)convertView.findViewById(R.id.txtChild);
        txtChild.setText(topics);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
