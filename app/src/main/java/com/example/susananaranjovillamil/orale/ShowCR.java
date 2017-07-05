package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowCR extends AppCompatActivity implements View.OnClickListener{

    Button homeButton;
    ArrayList<Pictogram> symptoms =null;
    ArrayList<Pictogram> pictogramsRepository = null;
    ListView list;
    ArrayList<ArrayList<Pictogram>> symptoms_list = new ArrayList<>();
    ArrayList<String> listDataHeader;
    HashMap<String, ArrayList<Pictogram>> listDataChild;
    ExpendableListAdapter listAdapter;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_cr);
        Intent in =getIntent();
        symptoms=in.getParcelableArrayListExtra("symptoms");
        pictogramsRepository= PictogramsRepository.getInstance().getPictograms();

        homeButton= (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpendableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);




    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.homeButton:

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;


            default:
                break;
        }
    }


    public ArrayList<String>  get_body_subparts (ArrayList<Pictogram> pictograms){
        ArrayList<String> body_subparts_names = new ArrayList();
        String sub_part_name;
        for(int i = 0; i < pictograms.size(); i++) {
            sub_part_name = pictograms.get(i).getBodySubpart();
            List provisoire = Arrays.asList(body_subparts_names);
            if (!body_subparts_names.contains(sub_part_name)) {
                body_subparts_names.add(sub_part_name);
            }
        }
        return body_subparts_names;

    }

    public ArrayList<ArrayList<Pictogram>>  get_the_list (ArrayList<Pictogram> pictograms, ArrayList<String>  body_subparts){
        ArrayList<ArrayList<Pictogram>> final_list = new ArrayList();
        String sub_part = null;
        String sub_part_2 = null;
        for(int i = 0; i < body_subparts.size(); i++) {
            final_list.add(new ArrayList<Pictogram>());
            sub_part = body_subparts.get(i);
            for(int j = 0; j < pictograms.size(); j++){
                sub_part_2 = pictograms.get(j).getBodySubpart();
                Log.d("my_tag",sub_part_2);
                Log.d("my_tag_2",sub_part);
                Log.d("my_tag_3",Integer.toString(i));
                Log.d("my_tag_4",Integer.toString(j));
                Log.d("my_tag_5",Integer.toString(body_subparts.size()));
                Log.d("my_tag_6",Integer.toString(pictograms.size()));
                if(sub_part_2.equals(sub_part)){
                    Log.d("my_tag_7",sub_part_2);
                    Log.d("my_tag_8",sub_part);
                    final_list.get(i).add(pictograms.get(j));



                }
            }
        }
        return final_list;
    }

    public HashMap<String, ArrayList<Pictogram>>   get_the_Hmap (ArrayList<ArrayList<Pictogram>> arraying, ArrayList<String>  body_subparts){
        HashMap<String, ArrayList<Pictogram>>  final_Hmap = new HashMap<String, ArrayList<Pictogram>>() ;
        String sub_part = null;
        String sub_part_2 = null;
        for(int i = 0; i < body_subparts.size(); i++) {
            ArrayList<Pictogram> listing = arraying.get(i);
            String provisoire = body_subparts.get(i);
            final_Hmap.put(provisoire,listing);
        }

        return final_Hmap;
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, ArrayList<Pictogram>>();
        listDataHeader = get_body_subparts(symptoms);
        ArrayList<ArrayList<Pictogram>> listi = get_the_list(symptoms,listDataHeader);
        listDataChild = get_the_Hmap(listi, listDataHeader);


    }



}
