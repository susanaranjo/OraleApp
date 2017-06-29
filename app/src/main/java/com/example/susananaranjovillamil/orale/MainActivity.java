package com.example.susananaranjovillamil.orale;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button saveButton;
    final Context context = this;
    GridView list;
    GridView listSelected;
    CustomListAdapter adapter=null;
    AdapterSelected adapter2=null;
    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> bodyParts = null;
    ArrayList<Pictogram> symptoms =null;
    int in_index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        saveButton= (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

        pictograms= PictogramsRepository.getInstance().getPictograms();
        bodyParts=new ArrayList<Pictogram>();
        symptoms=new ArrayList<Pictogram>();
        addbodyParts();


        list=(GridView)findViewById(R.id.list);
        adapter=new CustomListAdapter(this, bodyParts);
        list.setAdapter((ArrayAdapter) adapter);

        listSelected=(GridView)findViewById(R.id.list_selected);
        adapter2=new AdapterSelected(this, symptoms);
        listSelected.setAdapter((ArrayAdapter) adapter2);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(view.getContext(), ShowBodySubpart.class);
                intent.putExtra("bodyPart",bodyParts.get(+position).getName());
                startActivityForResult(intent,1);

            }
        });


        listSelected.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {


                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                final View mView = getLayoutInflater().inflate(R.layout.delete_dialog,null);
                ImageView picto = (ImageView) mView.findViewById(R.id.picto);
                picto.setImageResource(symptoms.get(+position).getImgid());
                Button cancel = (Button) mView.findViewById(R.id.button);
                Button delete = (Button) mView.findViewById(R.id.button2);

                alertDialogBuilder.setView(mView);
                final AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();

                delete.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        symptoms.remove(symptoms.get(+position));
                        adapter2.notifyDataSetChanged();
                        dialog.dismiss();

                    }

                });

                cancel.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        dialog.dismiss();

                    }

                });


            }
        });



    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.saveButton:

                if (symptoms.size()>0) {
                    Intent intent = new Intent(this, ShowSuggestion.class);
                    intent.putParcelableArrayListExtra("symptoms", symptoms);
                    startActivityForResult(intent, 2);
                }

                break;


            default:

                break;
        }
    }


    public void addbodyParts() {

        in_index=0;
        while(in_index < pictograms.size()) {

            if (pictograms.get(+in_index).getBodyPart().equals("")){

                bodyParts.add(pictograms.get(+in_index));
            }
            in_index++;

        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        in_index=0;
        int in_index2=0;
        int s=0;
        if (requestCode==1){
            if(resultCode == RESULT_OK){
                String symptomeSelected =data.getStringExtra("symptome");

                while(in_index2<symptoms.size()){

                    if(symptoms.get(+in_index2).getName().equals(symptomeSelected)){
                        s++;
                    }

                    in_index2++;
                }

                if(s==0) {
                    while (!pictograms.get(+in_index).getName().equals(symptomeSelected)) {

                        in_index++;
                    }

                    if(symptoms.size()<15) {
                        symptoms.add(pictograms.get(+in_index));
                        adapter2.notifyDataSetChanged();
                    } else {

                        //TO BE CONTINUED

                    }
                }

            }

        }

        if (requestCode==2){
            if(resultCode == RESULT_OK){

                ArrayList<Pictogram> finalSymptoms=data.getParcelableArrayListExtra("finalSymptoms");
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("finalSymptoms", finalSymptoms);
                setResult(RESULT_OK, intent);
                finish();


            }

        }


    }



}
