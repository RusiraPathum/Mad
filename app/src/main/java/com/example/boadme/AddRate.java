package com.example.boadme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRate extends AppCompatActivity {
    RatingBar ratingbar;
    Button button,buttonclose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_rate);


        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        ratingbar= findViewById(R.id.ratingBar2);
        button= findViewById(R.id.buttonSUBMIT);
        buttonclose= findViewById(R.id.closeratebtn);


        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
                String rating = String.valueOf(ratingbar.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddRate.this, homefeedbackActivity.class);



                startActivity(intent);

            }

        });
        buttonclose.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast

                Intent intent = new Intent(AddRate.this, homefeedbackActivity.class);



                startActivity(intent);

            }

        });
    }
}

