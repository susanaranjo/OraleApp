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
        pictograms.add(new Pictogram("","","p1",R.drawable.p1, year,month,day,""));
        pictograms.add(new Pictogram("","","p33",R.drawable.p33, year,month,day,""));
        pictograms.add(new Pictogram("","","p41",R.drawable.p41, year,month,day,""));
        pictograms.add(new Pictogram("","","p44",R.drawable.p44, year,month,day,""));
        pictograms.add(new Pictogram("","","p52",R.drawable.p52, year,month,day,""));
        pictograms.add(new Pictogram("","","p57",R.drawable.p57, year,month,day,""));
        pictograms.add(new Pictogram("","","p64",R.drawable.p64, year,month,day,""));
        pictograms.add(new Pictogram("","","p70",R.drawable.p70, year,month,day,""));

        pictograms.add(new Pictogram("p1","","p2",R.drawable.p2, year,month,day,""));
        pictograms.add(new Pictogram("p1","","p3",R.drawable.p3, year,month,day,""));
        pictograms.add(new Pictogram("p1","","p4",R.drawable.p4, year,month,day,""));
        pictograms.add(new Pictogram("p1","","p5",R.drawable.p5, year,month,day,""));
        pictograms.add(new Pictogram("p1","","p6",R.drawable.p6, year,month,day,""));
        pictograms.add(new Pictogram("p1","","p7",R.drawable.p7, year,month,day,""));
        pictograms.add(new Pictogram("p33","","p34",R.drawable.p34, year,month,day,""));
        pictograms.add(new Pictogram("p33","","p35",R.drawable.p35, year,month,day,""));
        pictograms.add(new Pictogram("p41","","p41",R.drawable.p41, year,month,day,""));
        pictograms.add(new Pictogram("p44","","p44",R.drawable.p44, year,month,day,""));
        pictograms.add(new Pictogram("p52","","p52",R.drawable.p52, year,month,day,""));
        pictograms.add(new Pictogram("p57","","p58",R.drawable.p58, year,month,day,""));
        pictograms.add(new Pictogram("p57","","p59",R.drawable.p59, year,month,day,""));
        pictograms.add(new Pictogram("p57","","p60",R.drawable.p60, year,month,day,""));
        pictograms.add(new Pictogram("p57","","p61",R.drawable.p61, year,month,day,""));
        pictograms.add(new Pictogram("p64","","p65",R.drawable.p65, year,month,day,""));
        pictograms.add(new Pictogram("p64","","p66",R.drawable.p66, year,month,day,""));
        pictograms.add(new Pictogram("p64","","p67",R.drawable.p67, year,month,day,""));
        pictograms.add(new Pictogram("p64","","p68",R.drawable.p68, year,month,day,""));
        pictograms.add(new Pictogram("p70","","p70",R.drawable.p70, year,month,day,""));

        pictograms.add(new Pictogram("p1","p2","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p1","p2","p9",R.drawable.p9, year,month,day,""));
        pictograms.add(new Pictogram("p1","p2","p10",R.drawable.p10, year,month,day,""));
        pictograms.add(new Pictogram("p1","p2","p11",R.drawable.p11, year,month,day,""));
        pictograms.add(new Pictogram("p1","p2","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p1","p2","p13",R.drawable.p13, year,month,day,""));
        pictograms.add(new Pictogram("p1","p3","p14",R.drawable.p14, year,month,day,""));
        pictograms.add(new Pictogram("p1","p3","p15",R.drawable.p15, year,month,day,""));
        pictograms.add(new Pictogram("p1","p3","p16",R.drawable.p16, year,month,day,""));
        pictograms.add(new Pictogram("p1","p3","p17",R.drawable.p17, year,month,day,""));
        pictograms.add(new Pictogram("p1","p4","p18",R.drawable.p18, year,month,day,""));
        pictograms.add(new Pictogram("p1","p4","p19",R.drawable.p19, year,month,day,""));
        pictograms.add(new Pictogram("p1","p4","p20",R.drawable.p20, year,month,day,""));
        pictograms.add(new Pictogram("p1","p4","p21",R.drawable.p21, year,month,day,""));
        pictograms.add(new Pictogram("p1","p5","p22",R.drawable.p22, year,month,day,""));
        pictograms.add(new Pictogram("p1","p5","p23",R.drawable.p23, year,month,day,""));
        pictograms.add(new Pictogram("p1","p5","p24",R.drawable.p24, year,month,day,""));
        pictograms.add(new Pictogram("p1","p5","p25",R.drawable.p25, year,month,day,""));
        pictograms.add(new Pictogram("p1","p5","p26",R.drawable.p26, year,month,day,""));
        pictograms.add(new Pictogram("p1","p6","p27",R.drawable.p27, year,month,day,""));
        pictograms.add(new Pictogram("p1","p7","p28",R.drawable.p28, year,month,day,""));
        pictograms.add(new Pictogram("p33","p34","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p33","p34","p36",R.drawable.p36, year,month,day,""));
        pictograms.add(new Pictogram("p33","p34","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p33","p34","p37",R.drawable.p37, year,month,day,""));
        pictograms.add(new Pictogram("p33","p35","p38",R.drawable.p38, year,month,day,""));
        pictograms.add(new Pictogram("p33","p35","p39",R.drawable.p39, year,month,day,""));
        pictograms.add(new Pictogram("p33","p35","p40",R.drawable.p40, year,month,day,""));
        pictograms.add(new Pictogram("p41","p41","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p41","p41","p42",R.drawable.p42, year,month,day,""));
        pictograms.add(new Pictogram("p41","p41","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p45",R.drawable.p45, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p46",R.drawable.p46, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p47",R.drawable.p47, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p48",R.drawable.p48, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p49",R.drawable.p49, year,month,day,""));
        pictograms.add(new Pictogram("p44","p44","p50",R.drawable.p50, year,month,day,""));
        pictograms.add(new Pictogram("p52","p52","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p52","p52","p53",R.drawable.p53, year,month,day,""));
        pictograms.add(new Pictogram("p52","p52","p54",R.drawable.p54, year,month,day,""));
        pictograms.add(new Pictogram("p52","p52","p55",R.drawable.p55, year,month,day,""));
        pictograms.add(new Pictogram("p52","p52","p56",R.drawable.p56, year,month,day,""));
        pictograms.add(new Pictogram("p57","p58","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p57","p58","p62",R.drawable.p62, year,month,day,""));
        pictograms.add(new Pictogram("p57","p58","p63",R.drawable.p63, year,month,day,""));
        pictograms.add(new Pictogram("p57","p58","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p57","p59","p38",R.drawable.p38, year,month,day,""));
        pictograms.add(new Pictogram("p57","p59","p39",R.drawable.p39, year,month,day,""));
        pictograms.add(new Pictogram("p57","p59","p40",R.drawable.p40, year,month,day,""));
        pictograms.add(new Pictogram("p57","p59","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p57","p60","p38",R.drawable.p38, year,month,day,""));
        pictograms.add(new Pictogram("p57","p60","p39",R.drawable.p39, year,month,day,""));
        pictograms.add(new Pictogram("p57","p60","p40",R.drawable.p40, year,month,day,""));
        pictograms.add(new Pictogram("p57","p60","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p57","p61","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p57","p61","p62",R.drawable.p62, year,month,day,""));
        pictograms.add(new Pictogram("p57","p61","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p64","p65","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p64","p65","p62",R.drawable.p62, year,month,day,""));
        pictograms.add(new Pictogram("p64","p65","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p64","p66","p38",R.drawable.p38, year,month,day,""));
        pictograms.add(new Pictogram("p64","p66","p39",R.drawable.p39, year,month,day,""));
        pictograms.add(new Pictogram("p64","p66","p40",R.drawable.p40, year,month,day,""));
        pictograms.add(new Pictogram("p64","p66","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p64","p67","p38",R.drawable.p38, year,month,day,""));
        pictograms.add(new Pictogram("p64","p67","p39",R.drawable.p39, year,month,day,""));
        pictograms.add(new Pictogram("p64","p67","p40",R.drawable.p40, year,month,day,""));
        pictograms.add(new Pictogram("p64","p67","p12",R.drawable.p12, year,month,day,""));
        pictograms.add(new Pictogram("p64","p68","p8",R.drawable.p8, year,month,day,""));
        pictograms.add(new Pictogram("p64","p68","p69",R.drawable.p69, year,month,day,""));

        pictograms.add(new Pictogram("p70","p70","p71",R.drawable.p71, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p72",R.drawable.p72, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p73",R.drawable.p73, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p74",R.drawable.p74, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p75",R.drawable.p75, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p76",R.drawable.p76, year,month,day,""));
        pictograms.add(new Pictogram("p70","p70","p77",R.drawable.p76, year,month,day,""));
    }



}
