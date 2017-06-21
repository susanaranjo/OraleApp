package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowCR extends AppCompatActivity implements View.OnClickListener{

    Button homeButton;
    ArrayList<Pictogram> symptoms =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_cr);
        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");

        homeButton= (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);

        //TO BE CONTINUED



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.homeButton:

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;


            default:
                break;
        }
    }


}
