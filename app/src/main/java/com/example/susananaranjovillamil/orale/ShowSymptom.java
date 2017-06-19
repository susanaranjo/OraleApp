package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import java.util.ArrayList;

public class ShowSymptom extends AppCompatActivity {


    GridView list;
    CustomListAdapter adapter=null;
    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> symptomes = null;
    int in_index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_symptoms);
        Intent intent =getIntent();
        String bodySubpart =intent.getStringExtra("bodySubpart");

        pictograms= PictogramsRepository.getInstance().getPictograms();
        symptomes=new ArrayList<Pictogram>();
        addSymptoms(bodySubpart);


        list=(GridView)findViewById(R.id.list);

        adapter=new CustomListAdapter(this, symptomes);
        list.setAdapter((ArrayAdapter) adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent();
                intent.putExtra("symptome",symptomes.get(+position).getName());
                setResult(RESULT_OK, intent);
                finish();

            }
        });



    }



    public void addSymptoms(String bodySubpart) {

        in_index=0;
        while(in_index < pictograms.size()) {

            if (pictograms.get(+in_index).getBodySubpart().equals(bodySubpart)){

                symptomes.add(pictograms.get(+in_index));
            }
            in_index++;

        }

    }


}

