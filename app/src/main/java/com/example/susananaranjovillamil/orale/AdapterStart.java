package com.example.susananaranjovillamil.orale;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/22/17.
 */

public class AdapterStart extends ArrayAdapter<Report> {

    private final Activity context;
    private final ArrayList<Report> reports;


    public AdapterStart(Activity context, ArrayList<Report> reports) {
        super(context, R.layout.list_date, reports);
        this.context=context;
        this.reports=reports;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_start, null,true);

        TextView txtDate = (TextView) rowView.findViewById(R.id.date);
        txtDate.setText(reports.get(position).getDay()+"/"+ reports.get(position).getMonth()+"/" + reports.get(position).getYear());

        return rowView;

    };
}
