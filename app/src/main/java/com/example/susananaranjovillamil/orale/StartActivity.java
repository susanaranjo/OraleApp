package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    Button addButton;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);


        addButton= (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        //TO BE CONTINUED

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addButton:

                Intent intent = new Intent(this, MainActivity.class);

                // TO BE CONTINUED

                startActivity(intent);

                break;


            default:

                break;
        }
    }
}



