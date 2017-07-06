package com.example.susananaranjovillamil.orale;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/20/17.
 */

public class AdapterConfirmation extends ArrayAdapter<Pictogram> {

    private final Activity context;
    private final ArrayList<Pictogram> pictograms;


    public AdapterConfirmation(Activity context, ArrayList<Pictogram> pictograms) {
        super(context, R.layout.list_date, pictograms);
        this.context=context;
        this.pictograms=pictograms;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_confirmation, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.picto);
        TextView txtDate = (TextView) rowView.findViewById(R.id.date);

        Calendar c = Calendar.getInstance();
        int day= c.get(Calendar.DAY_OF_MONTH);

        imageView.setImageResource(pictograms.get(position).getImgid());
        txtDate.setText(pictograms.get(position).getDay()+"/"+ pictograms.get(position).getMonth()+"/" +pictograms.get(position).getYear());


        return rowView;

    };



}
