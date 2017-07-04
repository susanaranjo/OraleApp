package com.example.susananaranjovillamil.orale;

import java.util.ArrayList;
import java.util.Arrays;

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
        illnesses.add(new Illness("hypertension", Arrays.asList("p11", "p60", "p61", "p18", "p14", "p9", "p63", "p56", "p52", "p41", "p32")));
        illnesses.add(new Illness("rhume", Arrays.asList("p58", "p64", "p25", "p11", "p15", "p16", "p19", "p20", "p24")));
        illnesses.add(new Illness("depression", Arrays.asList("p38", "p39", "p59", "p60", "p62", "p13")));
        illnesses.add(new Illness("hyperlipidemie", Arrays.asList("p37", "p31", "p9")));
        illnesses.add(new Illness("diabète", Arrays.asList("p44", "p26", "p39", "p37", "p42", "p59")));
        illnesses.add(new Illness("amygdalite-pharyngite", Arrays.asList("p25", "p20", "p42", "p58", "p11", "p60", "p24", "p28")));
        illnesses.add(new Illness("bronchite", Arrays.asList("p23", "p17", "p32", "p58", "p64", "p25", "p11", "p15", "p16", "p19", "p20", "p24")));
        illnesses.add(new Illness("angor: Angine de poitrine", Arrays.asList("p32", "p55", "p27")));
        illnesses.add(new Illness("otite", Arrays.asList("p58", "p20", "p13", "p21")));
        illnesses.add(new Illness("cystite", Arrays.asList("p44", "p46", "p47")));

    }



}
