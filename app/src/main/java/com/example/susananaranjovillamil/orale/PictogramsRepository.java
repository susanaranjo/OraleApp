package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Locale;

public class PictogramsRepository {

    private static PictogramsRepository repository = new PictogramsRepository();
    private ArrayList<Pictogram> pictograms = new ArrayList<>();

    public static PictogramsRepository getInstance() {
        return repository;
    }
    public ArrayList<Pictogram> getPictograms() {
        return pictograms;
    }

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day= c.get(Calendar.DAY_OF_MONTH);


    private PictogramsRepository () {
        pictograms.add(new Pictogram("","","ventre",R.drawable.p44, year,month,day));
        pictograms.add(new Pictogram("","","jambes",R.drawable.p57, year,month,day));
        pictograms.add(new Pictogram("","","bras",R.drawable.p64, year,month,day));
        pictograms.add(new Pictogram("","","corps",R.drawable.p70, year,month,day));

        pictograms.add(new Pictogram("ventre","","sventre",R.drawable.p44, year,month,day));
        pictograms.add(new Pictogram("ventre","","sjambes",R.drawable.p57, year,month,day));
        pictograms.add(new Pictogram("jambes","","sbras",R.drawable.p64, year,month,day));
        pictograms.add(new Pictogram("jambes","","scorps",R.drawable.p70, year,month,day));
        pictograms.add(new Pictogram("bras","","sventre",R.drawable.p44, year,month,day));
        pictograms.add(new Pictogram("bras","","sjambes",R.drawable.p57, year,month,day));
        pictograms.add(new Pictogram("corps","","sbras",R.drawable.p64, year,month,day));
        pictograms.add(new Pictogram("corps","","scorps",R.drawable.p70, year,month,day));

        pictograms.add(new Pictogram("ventre","sventre","x1",R.drawable.p44, year,month,day));
        pictograms.add(new Pictogram("ventre","sjambes","x2",R.drawable.p57, year,month,day));
        pictograms.add(new Pictogram("jambes","sbras","x3",R.drawable.p64, year,month,day));
        pictograms.add(new Pictogram("jambes","scorps","x4",R.drawable.p70, year,month,day));
        pictograms.add(new Pictogram("bras","sventre","x5",R.drawable.p44, year,month,day));
        pictograms.add(new Pictogram("bras","sjambes","x6",R.drawable.p57, year,month,day));
        pictograms.add(new Pictogram("corps","sbras","x7",R.drawable.p64, year,month,day));
        pictograms.add(new Pictogram("corps","scorps","x8",R.drawable.p70, year,month,day));


    }



}
