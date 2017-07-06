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

    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;



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

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        Button button9 = (Button) findViewById(R.id.button_9);
        Button button10 = (Button) findViewById(R.id.button_10);
        Button button11= (Button) findViewById(R.id.button_11);
        Button button12 = (Button) findViewById(R.id.button_12);
        Button button13 = (Button) findViewById(R.id.button_13);
        Button button14 = (Button) findViewById(R.id.button_14);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);

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

            case R.id.button_1 :{
                Intent intent = new Intent(v.getContext(), ShowBodySubpart.class);
                intent.putExtra("bodyPart","p1");
                startActivityForResult(intent,1);}
                break;

            case R.id.button_2 :
                Intent intent2 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent2.putExtra("bodyPart","p29");
                startActivityForResult(intent2,1);
                break;

            case R.id.button_3 :
                Intent intent3 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent3.putExtra("bodyPart","p36");
                startActivityForResult(intent3,1);
                break;

            case R.id.button_4 :
                Intent intent4 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent4.putExtra("bodyPart","p43");
                startActivityForResult(intent4,1);
                break;


            case R.id.button_5 :
                Intent intent5 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent5.putExtra("bodyPart","p48");
                startActivityForResult(intent5,1);
                break;

            case R.id.button_6 :
                Intent intent6 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent6.putExtra("bodyPart","p53");
                startActivityForResult(intent6,1);
                break;

            case R.id.button_7 :
                Intent intent7 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent7.putExtra("bodyPart","p53");
                startActivityForResult(intent7,1);
                break;

            case R.id.button_8 :
                Intent intent8 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent8.putExtra("bodyPart","p53");
                startActivityForResult(intent8,1);
                break;

            case R.id.button_9 :
                Intent intent9 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent9.putExtra("bodyPart","p53");
                startActivityForResult(intent9,1);
                break;

            case R.id.button_10 :
                Intent intent10 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent10.putExtra("bodyPart","p1");
                startActivityForResult(intent10,1);
                break;

            case R.id.button_11 :
                Intent intent11 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent11.putExtra("bodyPart","p33");
                startActivityForResult(intent11,1);
                break;

            case R.id.button_12 :
                Intent intent12 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent12.putExtra("bodyPart","p33");
                startActivityForResult(intent12,1);
                break;


            case R.id.button_13 :
                Intent intent13 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent13.putExtra("bodyPart","p43");
                startActivityForResult(intent13,1);
                break;

            case R.id.button_14 :
                Intent intent14 = new Intent(v.getContext(), ShowBodySubpart.class);
                intent14.putExtra("bodyPart","p48");
                startActivityForResult(intent14,1);
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
