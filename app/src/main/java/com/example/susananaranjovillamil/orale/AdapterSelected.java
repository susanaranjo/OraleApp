package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
public class AdapterSelected extends ArrayAdapter<Pictogram> {


    private final Activity context;
    private final ArrayList<Pictogram> pictograms;


    public AdapterSelected(Activity context, ArrayList<Pictogram> pictograms) {
        super(context, R.layout.list_selected, pictograms);
        this.context=context;
        this.pictograms=pictograms;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_selected, null,true);


        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        imageView.setImageResource(pictograms.get(position).getImgid());

        return rowView;

    }
}
