package com.example.susananaranjovillamil.orale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    Button addButton;
    ArrayList<Pictogram> finalSymptoms = null;
    ArrayList<Report> reports = null;
    Context context;
    ListView list;
    AdapterStart adapter;
    SharedPreference sharedPreference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        addButton= (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        sharedPreference = new SharedPreference();
        reports=sharedPreference.loadFavorites(this);
        if (reports==null){
            reports=new ArrayList<Report>();
        }


        list=(ListView)findViewById(R.id.list);
        adapter=new AdapterStart(this, reports);
        list.setAdapter((ArrayAdapter) adapter);



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addButton:

                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent,1);

                break;


            default:

                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if(resultCode == RESULT_OK){

                finalSymptoms=data.getParcelableArrayListExtra("finalSymptoms");
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH) + 1;
                int day= c.get(Calendar.DAY_OF_MONTH);
                reports.add(new Report(day, month, year, finalSymptoms));
                adapter.notifyDataSetChanged();

                sharedPreference.addFavorite(this.getApplicationContext(), new Report(day, month, year, finalSymptoms));

            }

        }


    }

}



