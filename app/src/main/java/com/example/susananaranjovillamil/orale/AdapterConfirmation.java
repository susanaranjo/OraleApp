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

        //TO BE CONTINUED

        return rowView;

    };



}
