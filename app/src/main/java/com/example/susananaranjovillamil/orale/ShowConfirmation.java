package com.example.susananaranjovillamil.orale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

public class ShowConfirmation extends AppCompatActivity implements View.OnClickListener{


    Button showCRButton;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_confirmation);
        Intent in =getIntent();



        showCRButton= (Button) findViewById(R.id.showCRButton);
        showCRButton.setOnClickListener(this);

        homeButton= (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);

        //TO BE CONTINUED



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.showCRButton:

                Intent intent = new Intent(this, ShowCR.class);

                //TO BE CONTINUED

                startActivity(intent);

                break;


            case R.id.homeButton:

                Intent intent2 = new Intent();

                //TO BE CONTINUED

                setResult(RESULT_OK, intent2);
                finish();

                break;


            default:
                break;
        }
    }

}
