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

public class ShowSuggestion extends AppCompatActivity implements View.OnClickListener{

    GridView list;
    GridView listSelected;
    AdapterSelected adapter2=null;
    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> symptoms =null;
    ArrayList<Pictogram> symptomsSuggested =null;
    ArrayList<Illness> illnesses=null;
    Button saveButton;
    CustomListAdapter adapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_suggestions);


        saveButton= (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
        pictograms= PictogramsRepository.getInstance().getPictograms();
        illnesses=IllnessesRepository.getInstance().getIllnesses();


        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");

        symptomsSuggested=new ArrayList<Pictogram>();
        addSugestions();

        if (symptomsSuggested.size()==0){
            Intent intent = new Intent(this, ShowCauses.class);
            intent.putParcelableArrayListExtra("symptoms", symptoms);
            startActivityForResult(intent,1);

        }


        list=(GridView)findViewById(R.id.list);
        adapter=new CustomListAdapter(this, symptomsSuggested);
        list.setAdapter((ArrayAdapter) adapter);

        listSelected=(GridView)findViewById(R.id.list_selected);
        adapter2=new AdapterSelected(this, symptoms);
        listSelected.setAdapter((ArrayAdapter) adapter2);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int in_index = 0;
                while((!pictograms.get(+in_index).getName().equals(symptomsSuggested.get(+position).getName()))){

                    in_index++;
                }

                symptoms.add(pictograms.get(in_index));
                adapter2.notifyDataSetChanged();

            }
        });


        listSelected.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // TO BE CONTINUED
                //Delete selected symptom

            }
        });


    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.saveButton:

                Intent intent = new Intent(this, ShowCauses.class);
                intent.putParcelableArrayListExtra("symptoms", symptoms);
                startActivityForResult(intent,1);

                break;


            default:
                break;
        }
    }



    public void addSugestions() {

        int in_index=0;
        int in_index2=0;
        int in_index3=0;
        int in_index4=0;
        int s=0;
        int s2=0;

        while(in_index < illnesses.size()) {


            while (in_index2<illnesses.get(+in_index).getSymptoms().size()){

                while (in_index3<symptoms.size()){

                    if(symptoms.get(+in_index3).getName().equals(illnesses.get(+in_index).getSymptoms().get(+in_index2))){
                        s++;
                    }
                    in_index3++;
                }

                in_index2++;
                in_index3=0;
            }


            if(s>1){
                in_index2=0;
                in_index3=0;
                while (in_index2<illnesses.get(+in_index).getSymptoms().size()){
                    while((!pictograms.get(+in_index3).getName().equals(illnesses.get(+in_index).getSymptoms().get(+in_index2)))){

                        in_index3++;
                    }

                    while(in_index4<symptoms.size()){
                        if(illnesses.get(+in_index).getSymptoms().get(+in_index2).equals(symptoms.get(+in_index4).getName())){
                          s2++;
                        }
                        in_index4++;
                    }
                    if (s2==0){
                        symptomsSuggested.add(pictograms.get(in_index3));
                    }
                    s2=0;
                    in_index2++;
                    in_index3=0;
                    in_index4=0;
                }


            }
            s=0;

            in_index++;
            in_index2=0;
        }

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if(resultCode == RESULT_OK){

                ArrayList<Pictogram> finalSymptoms=data.getParcelableArrayListExtra("finalSymptoms");
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("finalSymptoms", finalSymptoms);
                setResult(RESULT_OK, intent);
                finish();

            }else{

                finish();
            }

        }


    }

}
