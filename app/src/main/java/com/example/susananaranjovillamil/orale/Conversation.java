package com.example.susananaranjovillamil.orale;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by susana.naranjo.villamil on 6/29/17.
 */

public class Conversation extends AppCompatActivity {


    ArrayList<Pictogram> pictograms = null;
    ArrayList<String> items;
    final Context context = this;

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);

        // Listview Data
        pictograms = PictogramsRepository.getInstance().getPictograms();


        items = new ArrayList<String>();
        for (int position = 0; position < pictograms.size(); position ++){
            if(!pictograms.get(+position).getBodySubpart().equals("")) {
                items.add(pictograms.get(+position).getDescription());
            }
        }


        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_conversation, R.id.product_name, items);
        lv.setAdapter(adapter);

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                Conversation.this.adapter.getFilter().filter(cs);



            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {


            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                int in_index=0;

                hideSoftKeyboard(Conversation.this);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                final View mView = getLayoutInflater().inflate(R.layout.conversation_dialog,null);

                ImageView picto = (ImageView) mView.findViewById(R.id.picto);


                while (!pictograms.get(+in_index).getDescription().equals(adapter.getItem(+position))) {

                    in_index++;
                }

                picto.setImageResource(pictograms.get(+in_index).getImgid());

                Button  cancel= (Button) mView.findViewById(R.id.button);
                Button approve = (Button) mView.findViewById(R.id.button2);

                alertDialogBuilder.setView(mView);
                final AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();

                approve.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        dialog.dismiss();
                        Toast toast=Toast.makeText(context, "Le patient présent aussi " + adapter.getItem(+position), Toast.LENGTH_LONG);
                        toast.show();
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


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

}
