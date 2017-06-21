package com.example.susananaranjovillamil.orale;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class AddDate extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener{

    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> symptoms =null;
    ListView list;
    AdapterDate adapter;
    Button saveButton;
    int in_index=0;
    int day, month, year;
    int dayFinal, monthFinal, yearFinal;
    int listPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dates);


        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");

        saveButton= (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

        list=(ListView)findViewById(R.id.list);
        adapter=new AdapterDate(this, symptoms);
        list.setAdapter((ArrayAdapter) adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH) + 1;
                day= c.get(Calendar.DAY_OF_MONTH);
                listPosition=position;
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddDate.this, AddDate.this, year, month, day);
                datePickerDialog.show();



            }
        });

    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.saveButton:

                Intent intent = new Intent(this, ShowConfirmation.class);
                intent.putParcelableArrayListExtra("symptoms", symptoms);
                startActivityForResult(intent,1);

                break;


            default:
                break;
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                ArrayList<Pictogram> finalSymptoms=data.getParcelableArrayListExtra("finalSymptoms");
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("finalSymptoms", finalSymptoms);
                setResult(RESULT_OK, intent);
                finish();

            }

        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        yearFinal= year;
        monthFinal=month;
        dayFinal=day;
        symptoms.get(+listPosition).setDay(dayFinal);
        symptoms.get(+listPosition).setMonth(monthFinal);
        symptoms.get(+listPosition).setYear(yearFinal);
        adapter.notifyDataSetChanged();

    }
}
