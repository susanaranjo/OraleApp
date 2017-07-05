package com.example.susananaranjovillamil.orale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * Created by susana.naranjo.villamil on 6/21/17.
 */

public class ShowCauses extends AppCompatActivity implements View.OnClickListener {



    GridView list;
    GridView listSelected;
    AdapterSelected adapter2=null;
    ArrayList<Pictogram> pictograms = null;
    ArrayList<Pictogram> symptoms =null;
    ArrayList<Pictogram> causes =null;
    Button saveButton;
    CustomListAdapter adapter=null;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_causes);


        saveButton= (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
        pictograms= PictogramsRepository.getInstance().getPictograms();

        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");

        causes=new ArrayList<Pictogram>();
        addCauses();

        if (causes.size()==0){
            Intent intent = new Intent(this, AddDate.class);
            intent.putParcelableArrayListExtra("symptoms", symptoms);
            startActivityForResult(intent,1);

        }


        list=(GridView)findViewById(R.id.list);
        adapter=new CustomListAdapter(this, causes);
        list.setAdapter((ArrayAdapter) adapter);


        listSelected=(GridView)findViewById(R.id.list_selected);
        adapter2=new AdapterSelected(this, symptoms);
        listSelected.setAdapter((ArrayAdapter) adapter2);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int in_index = 0;
                while((!pictograms.get(+in_index).getName().equals(causes.get(+position).getName()))){

                    in_index++;
                }

                symptoms.add(pictograms.get(in_index));
                adapter2.notifyDataSetChanged();

            }
        });


        listSelected.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

                Intent intent = new Intent(this, AddDate.class);
                intent.putParcelableArrayListExtra("symptoms", symptoms);
                startActivityForResult(intent,1);

                break;


            default:
                break;
        }
    }



    public void addCauses() {

        int in_index=0;
        int in_index2=0;
        int in_index3=0;
        int s=0;

        while(in_index < symptoms.size()) {

           if (!symptoms.get(+in_index).getCause().equals("")){

               while(in_index3<causes.size()){

                   if(causes.get(+in_index3).getName().equals(symptoms.get(+in_index).getCause())){
                       s++;
                   }

                   in_index3++;
               }

               if(s==0) {

                   while((!pictograms.get(+in_index2).getName().equals(symptoms.get(+in_index).getCause()))){

                       in_index2++;
                   }

                   causes.add(pictograms.get(+in_index2));

               }


            }
            in_index2=0;
            in_index3=0;
            s=0;
            in_index++;
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
