package com.example.susananaranjovillamil.orale;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/28/17.
 */

public class AdapterReport extends ArrayAdapter<Pictogram> {



    private final Activity context;
    private final ArrayList<Pictogram> pictograms;


    public AdapterReport(Activity context, ArrayList<Pictogram> pictograms) {
            super(context, R.layout.list_report, pictograms);
            this.context=context;
            this.pictograms=pictograms;
            }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.list_report, null,true);


            ImageView imageView = (ImageView) rowView.findViewById(R.id.picto);
            TextView txtDate = (TextView) rowView.findViewById(R.id.date);

            imageView.setImageResource(pictograms.get(position).getImgid());
            txtDate.setText(pictograms.get(position).getDay()+"/"+ pictograms.get(position).getMonth()+"/" +pictograms.get(position).getYear());

            return rowView;

            }

}
