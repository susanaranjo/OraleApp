package com.example.susananaranjovillamil.orale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/20/17.
 */

public class IllnessesRepository {



    private static IllnessesRepository repository = new IllnessesRepository();
    private ArrayList<Illness> illnesses = new ArrayList<>();

    public static IllnessesRepository getInstance() {
        return repository;
    }
    public ArrayList<Illness> getIllnesses() {
        return illnesses;
    }




    private IllnessesRepository () {
        illnesses.add(new Illness("hypertension", Arrays.asList("p11", "p73", "p74", "p18", "p14", "p9", "p76", "p62")));
        illnesses.add(new Illness("rhume", Arrays.asList("p71", "p77", "p25", "p11", "p15", "p16", "p19", "p21", "p22", "p23")));
        illnesses.add(new Illness("depression", Arrays.asList("p72", "p73", "p75", "p13")));
        illnesses.add(new Illness("hyperlipidemie", Arrays.asList("p45", "p36", "p9")));
        illnesses.add(new Illness("arthrose", Arrays.asList("p38", "p39", "p40")));
        illnesses.add(new Illness("tourista", Arrays.asList("p45", "p48", "p49", "p50", "p73")));

        //To BE CONTINUED


    }



}
