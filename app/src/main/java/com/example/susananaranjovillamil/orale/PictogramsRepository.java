package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import java.util.ArrayList;
import java.util.Calendar;

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
        pictograms.add(new Pictogram("","","p1",R.drawable.p1, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p29",R.drawable.p29, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p33",R.drawable.p33, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p36",R.drawable.p36, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p43",R.drawable.p43, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p48",R.drawable.p48, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p53",R.drawable.p53, year,month,day,"",""));
        pictograms.add(new Pictogram("","","p57",R.drawable.p57, year,month,day,"",""));

        pictograms.add(new Pictogram("p1","","p2",R.drawable.p2, year,month,day,"Tête",""));
        pictograms.add(new Pictogram("p1","","p3",R.drawable.p3, year,month,day,"Nez",""));
        pictograms.add(new Pictogram("p1","","p4",R.drawable.p4, year,month,day,"Oreille",""));
        pictograms.add(new Pictogram("p1","","p5",R.drawable.p5, year,month,day,"Gorge",""));
        pictograms.add(new Pictogram("p1","","p6",R.drawable.p6, year,month,day,"Nuque",""));
        pictograms.add(new Pictogram("p1","","p7",R.drawable.p7, year,month,day,"Bouche",""));
        pictograms.add(new Pictogram("p29","","p30",R.drawable.p30, year,month,day,"Pointrine",""));
        pictograms.add(new Pictogram("p33","","p34",R.drawable.p34, year,month,day,"Dos",""));
        pictograms.add(new Pictogram("p36","","p361",R.drawable.p36, year,month,day,"Ventre",""));
        pictograms.add(new Pictogram("p43","","p431",R.drawable.p43, year,month,day,"Parties privées",""));
        pictograms.add(new Pictogram("p48","","p49",R.drawable.p49, year,month,day,"Jambe",""));
        pictograms.add(new Pictogram("p48","","p50",R.drawable.p50, year,month,day,"Pied",""));
        pictograms.add(new Pictogram("p53","","p54",R.drawable.p54, year,month,day,"Main",""));
        pictograms.add(new Pictogram("p57","","p571",R.drawable.p57, year,month,day,"Corps entier",""));


        pictograms.add(new Pictogram("p1","p2","p8",R.drawable.p8, year,month,day,"Dermatose - eczema sur le visage",""));
        pictograms.add(new Pictogram("p1","p2","p9",R.drawable.p9, year,month,day,"Confusion- perte de mémoire",""));
        pictograms.add(new Pictogram("p1","p2","p10",R.drawable.p10, year,month,day,"Anxiété-angoisse",""));
        pictograms.add(new Pictogram("p1","p2","p11",R.drawable.p11, year,month,day,"Mal à la tête",""));
        pictograms.add(new Pictogram("p1","p2","p12",R.drawable.p12, year,month,day,"Contusion à la tête",""));
        pictograms.add(new Pictogram("p1","p2","p13",R.drawable.p13, year,month,day,"Irritabilité","p65"));
        pictograms.add(new Pictogram("p1","p3","p14",R.drawable.p14, year,month,day,"Saignements de nez","p66"));
        pictograms.add(new Pictogram("p1","p3","p15",R.drawable.p15, year,month,day,"Obstruction nasale",""));
        pictograms.add(new Pictogram("p1","p3","p16",R.drawable.p16, year,month,day,"Rhinorrhée mucopurulent",""));
        pictograms.add(new Pictogram("p1","p3","p17",R.drawable.p17, year,month,day,"Respiration sifflante",""));
        pictograms.add(new Pictogram("p1","p4","p18",R.drawable.p18, year,month,day,"Bourdonnements d'oreilles","p67"));
        pictograms.add(new Pictogram("p1","p4","p19",R.drawable.p19, year,month,day,"Basse de l'audition",""));
        pictograms.add(new Pictogram("p1","p4","p20",R.drawable.p20, year,month,day,"Douleur dans une oreille",""));
        pictograms.add(new Pictogram("p1","p4","p21",R.drawable.p21, year,month,day,"Liquide dans une oreille",""));
        pictograms.add(new Pictogram("p1","p5","p22",R.drawable.p22, year,month,day,"Toux",""));
        pictograms.add(new Pictogram("p1","p5","p23",R.drawable.p23, year,month,day,"Toux accompagnée de mucus ou fleme",""));
        pictograms.add(new Pictogram("p1","p5","p24",R.drawable.p24, year,month,day,"Inflammation des ganglios lymphatiques",""));
        pictograms.add(new Pictogram("p1","p5","p25",R.drawable.p25, year,month,day,"Mal à la  gorge",""));
        pictograms.add(new Pictogram("p1","p5","p26",R.drawable.p26, year,month,day,"Soif ","p66"));
        pictograms.add(new Pictogram("p1","p6","p27",R.drawable.p27, year,month,day,"Mal à la nuque ",""));
        pictograms.add(new Pictogram("p1","p7","p28",R.drawable.p28, year,month,day,"Mouvaise haleine",""));
        pictograms.add(new Pictogram("p29","p30","p31",R.drawable.p31, year,month,day,"Difficulté respirant","p68"));
        pictograms.add(new Pictogram("p29","p30","p32",R.drawable.p32, year,month,day,"Douleur à la pointrine",""));
        pictograms.add(new Pictogram("p33","p34","p35",R.drawable.p35, year,month,day,"Lombalgie","p69"));
        pictograms.add(new Pictogram("p36","p361","p37",R.drawable.p37, year,month,day,"Douleur abdominale - mal au ventre","p70"));
        pictograms.add(new Pictogram("p36","p361","p38",R.drawable.p38, year,month,day,"Appétit reduit",""));
        pictograms.add(new Pictogram("p36","p361","p39",R.drawable.p39, year,month,day,"Appétit augmenté",""));
        pictograms.add(new Pictogram("p36","p361","p40",R.drawable.p40, year,month,day,"Diarrhee","p70"));
        pictograms.add(new Pictogram("p36","p361","p41",R.drawable.p41, year,month,day,"Nausées",""));
        pictograms.add(new Pictogram("p36","p361","p42",R.drawable.p42, year,month,day,"Vomissement","p71"));
        pictograms.add(new Pictogram("p43","p431","p44",R.drawable.p44, year,month,day,"Envie fréquente d'urinier",""));
        pictograms.add(new Pictogram("p43","p431","p45",R.drawable.p45, year,month,day,"Constipation","p72"));
        pictograms.add(new Pictogram("p43","p431","p46",R.drawable.p46, year,month,day,"Douleurs en urinant",""));
        pictograms.add(new Pictogram("p43","p431","p47",R.drawable.p47, year,month,day,"Urines avec sang",""));

        pictograms.add(new Pictogram("p48","p49","p51",R.drawable.p51, year,month,day,"jambes lourdes",""));
        pictograms.add(new Pictogram("p48","p50","p52",R.drawable.p52, year,month,day,"fourmillements",""));

        pictograms.add(new Pictogram("p53","p54","p55",R.drawable.p55, year,month,day,"mal à la main gauche",""));
        pictograms.add(new Pictogram("p53","p54","p56",R.drawable.p56, year,month,day,"fourmillements",""));


        pictograms.add(new Pictogram("p57","p571","p58",R.drawable.p58, year,month,day,"fièvre","p66"));
        pictograms.add(new Pictogram("p57","p571","p59",R.drawable.p59, year,month,day,"Variation du poids corporel",""));
        pictograms.add(new Pictogram("p57","p571","p60",R.drawable.p60, year,month,day,"asthénie-fatigue-malaise géneraliste",""));
        pictograms.add(new Pictogram("p57","p571","p61",R.drawable.p61, year,month,day,"vertiges","p32"));
        pictograms.add(new Pictogram("p57","p571","p62",R.drawable.p62, year,month,day,"insomnie",""));
        pictograms.add(new Pictogram("p57","p571","p63",R.drawable.p63, year,month,day,"somnolence",""));
        pictograms.add(new Pictogram("p57","p571","p64",R.drawable.p64, year,month,day,"frissons",""));


        pictograms.add(new Pictogram("p0","p0","p0",R.drawable.p1, year,month,day,"Facteurs externes",""));
        pictograms.add(new Pictogram("p65","p0","p65",R.drawable.p65, year,month,day,"contraceptif",""));
        pictograms.add(new Pictogram("p66","p0","p66",R.drawable.p66, year,month,day,"forte chaleur/canicule",""));
        pictograms.add(new Pictogram("p67","p0","p67",R.drawable.p67, year,month,day,"voyage",""));
        pictograms.add(new Pictogram("p68","p0","p68",R.drawable.p68, year,month,day,"obésité",""));
        pictograms.add(new Pictogram("p69","p0","p69",R.drawable.p69, year,month,day,"soulèvement de charge",""));
        pictograms.add(new Pictogram("p70","p0","p70",R.drawable.p70, year,month,day,"nourriture exotique",""));
        pictograms.add(new Pictogram("p71","p0","p71",R.drawable.p71, year,month,day,"chûte",""));
        pictograms.add(new Pictogram("p72","p0","p72",R.drawable.p72, year,month,day,"antibiotiques",""));

    }



}
