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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    Button addButton;
    ArrayList<Pictogram> finalSymptoms = null;
    ArrayList<Report> reports = null;
    ArrayList<Pictogram> symptoms =null;
    final Context context=this;
    ListView list;
    GridView listSelected;
    AdapterStart adapter = null;
    AdapterReport adapter2=null;
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

        symptoms=new ArrayList<Pictogram>();

        list=(ListView)findViewById(R.id.list);
        adapter=new AdapterStart(this, reports);
        list.setAdapter((ArrayAdapter) adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                symptoms =reports.get(+position).getSymptoms();


                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                final View mView = getLayoutInflater().inflate(R.layout.report_dialog,null);
                listSelected = (GridView) mView.findViewById(R.id.list_selected);
                adapter2=new AdapterReport(StartActivity.this,symptoms);
                listSelected.setAdapter((ArrayAdapter) adapter2);

                Button delete = (Button) mView.findViewById(R.id.button);
                Button report = (Button) mView.findViewById(R.id.button2);

                alertDialogBuilder.setView(mView);
                final AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();

                report.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        dialog.dismiss();
                        Intent intent = new Intent(context, ShowCR.class);
                        intent.putParcelableArrayListExtra("symptoms", symptoms);
                        startActivity(intent);

                    }

                });

                delete.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        dialog.dismiss();

                        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        final View mView = getLayoutInflater().inflate(R.layout.delete_report_dialog,null);
                        TextView date = (TextView) mView.findViewById(R.id.date);
                        date.setText(reports.get(+position).getDay()+"/"+ reports.get(+position).getMonth()+"/" + reports.get(+position).getYear());
                        Button cancel = (Button) mView.findViewById(R.id.button);
                        Button delete = (Button) mView.findViewById(R.id.button2);

                        alertDialogBuilder.setView(mView);
                        final AlertDialog dialog = alertDialogBuilder.create();
                        dialog.show();

                        delete.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View view){

                                reports.remove(reports.get(+position));
                                sharedPreference.storeFavorites(context,reports);
                                adapter.notifyDataSetChanged();
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
        });



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addButton:

                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent,1);

                break;


            case R.id.conversationButton:

                Intent intent2 = new Intent(this, MainActivity.class);
                startActivityForResult(intent2,2);

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

                sharedPreference.addFavorite(context, new Report(day, month, year, finalSymptoms));

            }

        }


        if (requestCode==2){
            if(resultCode == RESULT_OK){

                //TO BE CONTINUED

            }

        }



    }

}



