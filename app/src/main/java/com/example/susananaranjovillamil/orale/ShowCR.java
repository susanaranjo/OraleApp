package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowCR extends AppCompatActivity {


    ArrayList<Pictogram> symptoms =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_cr);
        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");


        //TO BE CONTINUED



    }


}
