package com.example.susananaranjovillamil.orale;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowSuggestion extends AppCompatActivity implements View.OnClickListener{


    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_suggestions);


        saveButton= (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

         //TO BE CONTINUED


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.saveButton:

                Intent intent = new Intent(this, AddDate.class);

                //TO BE CONTINUED

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

                Intent intent = new Intent();

                //TO BE CONTINUED

                setResult(RESULT_OK, intent);
                finish();

            }

        }


    }

}
