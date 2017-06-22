package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowConfirmation extends AppCompatActivity implements View.OnClickListener{


    Button showCRButton;
    Button homeButton;
    Button editButton;
    ArrayList<Pictogram> symptoms =null;
    AdapterConfirmation adapter=null;
    GridView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_confirmation);
        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");



        showCRButton= (Button) findViewById(R.id.showCRButton);
        showCRButton.setOnClickListener(this);

        homeButton= (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);

        editButton=(Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(this);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day= c.get(Calendar.DAY_OF_MONTH);
        TextView textDate = (TextView) findViewById(R.id.textDate);
        textDate.setText(day +"/"+ month + "/" + year);

        list=(GridView)findViewById(R.id.list);
        adapter=new AdapterConfirmation(this, symptoms);
        list.setAdapter((ArrayAdapter) adapter);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.showCRButton:

                Intent intent = new Intent(this, ShowCR.class);
                intent.putParcelableArrayListExtra("symptoms", symptoms);
                startActivityForResult(intent,1);
                break;


            case R.id.homeButton:

                Intent intent2 = new Intent();
                intent2.putParcelableArrayListExtra("finalSymptoms", symptoms);
                setResult(RESULT_OK, intent2);
                finish();
                break;

            case R.id.editButton:

                finish();
                break;



            default:
                break;
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Intent intent2 = new Intent();
                intent2.putParcelableArrayListExtra("finalSymptoms", symptoms);
                setResult(RESULT_OK, intent2);
                finish();

            }

        }
    }

}
