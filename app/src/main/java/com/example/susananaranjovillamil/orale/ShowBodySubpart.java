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

public class ShowBodySubpart extends AppCompatActivity {


    GridView list;
    CustomListAdapter adapter=null;
    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> bodySubparts = null;
    int in_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bodysubparts);
        Intent in =getIntent();
        String bodyPart =in.getStringExtra("bodyPart");
        //TextView textMessage = (TextView) findViewById(R.id.textMessage);
        //textMessage.setText( bodyPart);


        pictograms= PictogramsRepository.getInstance().getPictograms();
        bodySubparts=new ArrayList<Pictogram>();
        addbodySubparts(bodyPart);


        list=(GridView)findViewById(R.id.list);

        adapter=new CustomListAdapter(this, bodySubparts);
        list.setAdapter((ArrayAdapter) adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(view.getContext(), ShowSymptom.class);
                intent.putExtra("bodySubpart",bodySubparts.get(+position).getName());
                startActivityForResult(intent, 1);

            }
        });



    }



    public void addbodySubparts(String bodyPart) {

        in_index=0;
        while(in_index < pictograms.size()) {

            if (pictograms.get(+in_index).getBodyPart().equals(bodyPart)&&pictograms.get(+in_index).getBodySubpart().equals("")){

                bodySubparts.add(pictograms.get(+in_index));
            }
            in_index++;

        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if(resultCode == RESULT_OK){
                String symptomeSelected =data.getStringExtra("symptome");
                Intent intent = new Intent();
                intent.putExtra("symptome", symptomeSelected);
                setResult(RESULT_OK, intent);
                finish();
            }

        }


    }


}

