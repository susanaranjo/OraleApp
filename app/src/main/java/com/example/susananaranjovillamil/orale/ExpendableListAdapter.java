package com.example.susananaranjovillamil.orale;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by susana.naranjo.villamil on 7/4/17.
 */

public class ExpendableListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private ArrayList<String> name_subpart;
    private HashMap<String, ArrayList<Pictogram>> theList;

    public ExpendableListAdapter(Context context, ArrayList<String> headers, HashMap<String, ArrayList<Pictogram>> listing){
        this.context = context;
        this.name_subpart = headers;
        this.theList = listing;
    }

    @Override
    public Pictogram getChild(int groupPosition, int childPosititon) {
        return this.theList.get(this.name_subpart.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final Pictogram picto =  getChild(groupPosition, childPosition);
        final String childText = (String) picto.getName();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_cr, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        TextView txtListChild_date = (TextView) convertView
                .findViewById(R.id.lblListItem_date);

        txtListChild.setText(childText);
        txtListChild_date.setText(picto.getDay()+"/"+ picto.getMonth()+"/" +picto.getYear());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.theList.get(this.name_subpart.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.name_subpart.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.name_subpart.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_cr, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText("Sous-partie du corps : "+ headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
